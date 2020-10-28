package com.netflix.usuario.interfaces.controllers;

import com.netflix.usuario.application.services.domains.Usuario;
import com.netflix.usuario.application.usecase.GetUsuarioUseCase;
import com.netflix.usuario.interfaces.controllers.dto.ListaDTO;
import com.netflix.usuario.repositories.entities.HistoricoEntity;
import com.netflix.usuario.repositories.entities.UsuarioEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final GetUsuarioUseCase getUsuarioUseCase;
    private Object usuarioEntity;


    public UsuarioController(GetUsuarioUseCase getUsuarioUseCase){
        this.getUsuarioUseCase = getUsuarioUseCase;
    }
    @GetMapping("{id}")
    public Usuario get(@PathVariable(value="id") Long id) throws Exception {
        Optional<Usuario> user= getUsuarioUseCase.getById(id);
        return user.orElseThrow(() -> new RuntimeException("Usuário não existe."));

    }
    @GetMapping("/historico")
    public List<UsuarioEntity> findAll(){
        List<HistoricoEntity> all = getUsuarioUseCase.findAll();
        return null;

    }

    @PostMapping("{id}/assistir-futuramente")
    public ResponseEntity assistirFuturamente (
            @RequestHeader Map<String,String> headers,
            @RequestBody ListaDTO listaUser){

        String id = headers.get("user-id");
        listaUser.setId(Long.parseLong(id));


        getUsuarioUseCase.assistirFuturamente(listaUser);
        return ResponseEntity.ok().build();
    }

}