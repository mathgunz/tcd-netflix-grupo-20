package com.netflix.suporte.api.interfaces.controllers;

import com.netflix.suporte.api.application.usecases.PublicarChamadoUseCase;
import com.netflix.suporte.api.interfaces.controllers.dtos.SuporteDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/suporte-api")
@RestController
public class SuporteController {

    private final PublicarChamadoUseCase publicarChamadoUseCase;

    public SuporteController(PublicarChamadoUseCase publicarChamadoUseCase) {
        this.publicarChamadoUseCase = publicarChamadoUseCase;
    }

    @PostMapping("abrirChamado")
    public ResponseEntity abrirChamado(
            @RequestHeader Map<String, String> headers,
            @RequestBody SuporteDto suporte) {

        String userId = headers.get("user-id");
        suporte.setUsuarioId(Long.parseLong(userId));

        publicarChamadoUseCase.publicar(suporte);

        return ResponseEntity.ok().build();
    }
}