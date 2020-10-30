package com.netflix.usuario.interfaces.controllers;

import com.netflix.usuario.application.services.domains.MinhaLista;
import com.netflix.usuario.application.services.domains.Usuario;
import com.netflix.usuario.application.usecase.GetMinhaListaCase;
import com.netflix.usuario.application.usecase.GetUsuarioUseCase;
import com.netflix.usuario.repositories.entities.MinhaListaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final GetUsuarioUseCase getUsuarioUseCase;

    public UsuarioController(GetUsuarioUseCase getUsuarioUseCase){
        this.getUsuarioUseCase = getUsuarioUseCase;

    }

    @GetMapping("{id}")
    public Usuario get(@PathVariable(value="id") Long id) throws Exception {
        Optional<Usuario> user= getUsuarioUseCase.getById(id);
        return user.orElseThrow(() -> new RuntimeException("Usuário não existe."));

    }


}