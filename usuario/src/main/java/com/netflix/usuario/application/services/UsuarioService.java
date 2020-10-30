package com.netflix.usuario.application.services;

import com.netflix.usuario.application.services.domains.MinhaLista;
import com.netflix.usuario.application.services.domains.Usuario;
import com.netflix.usuario.application.usecase.GetMinhaListaCase;
import com.netflix.usuario.application.usecase.GetUsuarioUseCase;

import com.netflix.usuario.repositories.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService implements GetUsuarioUseCase {

    @Autowired
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository=usuarioRepository;
    }


    @Override
    public Optional<Usuario> getById(Long id) throws Exception {
        Optional<UsuarioEntity> result = usuarioRepository.findById(id);

        UsuarioEntity usuarioEntity = result.orElseThrow(
                () -> new Exception("Usuário não existe"));
        return Optional.of(toDomain(usuarioEntity));
    }
    /*
    @Override
    public void minhaLista (MinhaLista minhaLista){
        MinhaListaEntity listaEntity= new MinhaListaEntity();
        minhaListaRepository.save(listaEntity)
    }*/
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
