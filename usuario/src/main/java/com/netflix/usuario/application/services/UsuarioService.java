package com.netflix.usuario.application.services;

import com.netflix.usuario.application.services.domains.Usuario;
import com.netflix.usuario.application.usecase.GetUsuarioUseCase;

import com.netflix.usuario.interfaces.controllers.dtos.MinhaListaDTO;
import com.netflix.usuario.repositories.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements GetUsuarioUseCase {

    @Autowired
    private final UsuarioRepository usuarioRepository;
    private  MinhaListaRepository minhaListaRepository;
    private  HistoricoRepository historicoRepository;


    public UsuarioService(UsuarioRepository usuarioRepository, MinhaListaRepository minhaListaRepository,
                          HistoricoRepository historicoRepository){
        this.usuarioRepository=usuarioRepository;
        this.minhaListaRepository=minhaListaRepository;
        this.historicoRepository=historicoRepository;

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
    public MinhaListaEntity salvarFilme (MinhaListaDTO minhaListaDTO){
        MinhaListaEntity minhaListaEntity = new MinhaListaEntity();

        minhaListaEntity.setUsuarioEntity(minhaListaEntity.getUsuarioEntity());
        minhaListaEntity.setFilme(minhaListaEntity.getFilme());
        minhaListaEntity.setDataEscolha(minhaListaDTO.getDataEscolha());
        return minhaListaRepository.save(minhaListaEntity);
    }

    //Listar filmes que já foram assistidos
    public List<HistoricoEntity> listarHistorico(){
        return historicoRepository.findAll();
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
