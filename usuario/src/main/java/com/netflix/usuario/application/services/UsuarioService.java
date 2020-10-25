package com.netflix.usuario.application.services;

import com.netflix.usuario.application.services.domains.ListaUser;
import com.netflix.usuario.application.services.domains.Usuario;
import com.netflix.usuario.application.usecase.GetUsuarioUseCase;

import com.netflix.usuario.repositories.entities.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements GetUsuarioUseCase {

    private final UsuarioRepository usuarioRepository;
    private final HistoricoRepository historicoRepository;
    private final ListaUserRepository listaUserRepository;


    public UsuarioService(UsuarioRepository usuarioRepository, HistoricoRepository historicoRepository, ListaUserRepository listaUserRepository){
        this.usuarioRepository=usuarioRepository;
        this.historicoRepository = historicoRepository;
        this.listaUserRepository = listaUserRepository;
    }

    @Override
    public List<HistoricoEntity> findAllHistorico() {
        List<HistoricoEntity> hist=historicoRepository.findAllHistorico();
        return null;
    }

    @Override
    public Optional<Usuario> getByIdUser(Long idUser) throws Exception {
        Optional<UsuarioEntity> result = usuarioRepository.findById(idUser);

        UsuarioEntity usuarioEntity = result.orElseThrow(
                () -> new Exception("Usuário não existe"));
        return Optional.of(toDomain(usuarioEntity));

    }

    @Override
    public void assistirFuturamente(ListaUser listaUser) {
        ListaUserEntity listaUserEntity = new ListaUserEntity();
        listaUserEntity.setUsuarioEntity(listaUser.getUsuarioEntity());
        listaUserEntity.setFilme(listaUser.getFilme());
        listaUserEntity.setVisualizacaoFutura(listaUser.isVisualizacaoFutura());
        listaUser.setDataEscolha(listaUserEntity.getDataEscolha());
        listaUserRepository.save(listaUserEntity);
    }


    private Usuario toDomain(UsuarioEntity usuarioEntity){
        return Usuario.newBuilder()
                .withIdUser(usuarioEntity.getIdUser())
                .withNome(usuarioEntity.getNome())
                .withSobrenome(usuarioEntity.getSobrenome())
                .withEmail(usuarioEntity.getEmail())
                .withPassword(usuarioEntity.getPassword())
                .withCriacao(usuarioEntity.getCriacao())
                .withTipoConta(usuarioEntity.getTipoConta())
                .build();

    }


}
