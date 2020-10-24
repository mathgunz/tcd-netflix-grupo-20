package com.netflix.suporte.api.interfaces.controllers;

import com.netflix.suporte.api.application.usecases.PublicarChamadoUseCase;
import com.netflix.suporte.api.interfaces.controllers.dtos.SuporteDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/suporte-api")
@RestController
public class SuporteListener {

    private final PublicarChamadoUseCase publicarChamadoUseCase;

    public SuporteListener(PublicarChamadoUseCase publicarChamadoUseCase) {
        this.publicarChamadoUseCase = publicarChamadoUseCase;
    }

    @PostMapping("abrirChamado")
    public ResponseEntity abrirChamado(
            @RequestHeader Map<String, String> headers,
            @RequestBody SuporteDto suporte) {

        String userId = headers.get("userId");
        suporte.setUsuarioId(Long.getLong(userId));

        publicarChamadoUseCase.publicar(suporte);

        return ResponseEntity.ok().build();
    }
}