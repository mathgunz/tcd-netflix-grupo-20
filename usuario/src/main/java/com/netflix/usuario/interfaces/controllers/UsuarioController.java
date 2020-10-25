package com.netflix.usuario.interfaces.controllers;

import com.netflix.usuario.application.services.domains.Historico;
import com.netflix.usuario.application.services.domains.ListaUser;
import com.netflix.usuario.application.services.domains.Usuario;
import com.netflix.usuario.application.usecase.GetUsuarioUseCase;
import com.netflix.usuario.interfaces.controllers.dto.ListaDTO;
import com.netflix.usuario.repositories.entities.UsuarioEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequestMapping("/usuarios")
@RestController
public class UsuarioController {

    private final GetUsuarioUseCase getUsuarioUseCase;

    public UsuarioController(GetUsuarioUseCase getUsuarioUseCase){
        this.getUsuarioUseCase = getUsuarioUseCase;
    }

    @GetMapping("/{usuarioEntity}")
    public List<Historico> findAllHistorico(@RequestParam(value="usuarioEntity", required= false)
                                                        UsuarioEntity usuarioEntity){
        getUsuarioUseCase.findAllHistorico();
        return null;
    }

    @GetMapping("/{id}")
    public Usuario get(@PathVariable("id") Long idUser)throws Exception {
        Optional<Usuario> usuario = getUsuarioUseCase.getByIdUser(idUser);
        return usuario.orElseThrow(() -> new RuntimeException("Usuário não existe")) ;
    }

    @PostMapping("assistir-futuramente")
    public ResponseEntity assistirFuturamente (
            @RequestHeader Map<String,String> headers,
            @RequestBody ListaDTO listaUser){

        String idUser = headers.get("user-id");
        listaUser.setIdUser(Long.parseLong(idUser));


        getUsuarioUseCase.assistirFuturamente(listaUser);
        return ResponseEntity.ok().build();
    }

}