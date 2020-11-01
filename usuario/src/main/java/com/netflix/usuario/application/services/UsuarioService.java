package com.netflix.usuario.application.services;

import com.netflix.usuario.application.services.domains.MinhaLista;
import com.netflix.usuario.application.services.domains.Usuario;
import com.netflix.usuario.application.usecase.GetUsuarioUseCase;
import com.netflix.usuario.repositories.entities.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements GetUsuarioUseCase {

    private final UsuarioRepository usuarioRepository;
    private final MinhaListaRepository minhaListaRepository;
    private final HistoricoRepository historicoRepository;
    private final CatalogoSumarizadoRepository catalogoSumarizadoRepository;


    public UsuarioService(UsuarioRepository usuarioRepository, MinhaListaRepository minhaListaRepository,
                          HistoricoRepository historicoRepository, CatalogoSumarizadoRepository catalogoSumarizadoRepository){
        this.usuarioRepository=usuarioRepository;
        this.minhaListaRepository=minhaListaRepository;
        this.historicoRepository=historicoRepository;
        this.catalogoSumarizadoRepository=catalogoSumarizadoRepository;

    }
    //Recuperando ID Usuario
    @Override
    public Optional<Usuario> getById(Long id) throws Exception {
        Optional<UsuarioEntity> result = usuarioRepository.findById(id);

        UsuarioEntity usuarioEntity = result.orElseThrow(
                () -> new Exception("Usuário não existe"));
        return Optional.of(toDomain(usuarioEntity));
    }

    //Salvar um filme ou série para ser visto no futuro;
    @Override
    public void salvar(MinhaLista minhaLista) {
        Optional<UsuarioEntity> optional = usuarioRepository.findById(minhaLista.getUsuarioId());
        UsuarioEntity usuarioEntity = optional.orElseThrow(() -> new RuntimeException("Usuario não existe."));

        Optional<CatalogoSumarizadoEntity> optionalFilme = catalogoSumarizadoRepository.findById(minhaLista.getFilme());
        CatalogoSumarizadoEntity catalogoSumarizadoEntity =optionalFilme.orElseThrow(() ->
                                                            new RuntimeException("catalogo nao existe"));

        MinhaListaEntity minhaListaEntity = new MinhaListaEntity(usuarioEntity, minhaLista.getUsuarioId(),
                catalogoSumarizadoEntity, minhaLista.getFilme(), minhaLista.getDataEscolha());
        minhaListaRepository.save(minhaListaEntity);
    }

    //Listar Histórico do usuario
    @Override
    public List<HistoricoEntity> findAllHistorico() {
        List<HistoricoEntity> historicos = historicoRepository.findAll();
        return historicos;
    }

    private Usuario toDomain(UsuarioEntity usuarioEntity){
        return Usuario.newBuilder()
                .withId(usuarioEntity.getId())
                .withNome(usuarioEntity.getNome())
                .withSobrenome(usuarioEntity.getSobrenome())
                .withEmail(usuarioEntity.getEmail())
                .withPassword(usuarioEntity.getPassword())
                .withCriacao(usuarioEntity.getCriacao())
                .withTipoConta(usuarioEntity.getTipoConta())
                .build();
    }
}
