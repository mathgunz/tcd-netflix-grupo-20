package com.netflix.usuario.interfaces.controllers;

import com.netflix.usuario.application.services.domains.MinhaLista;
import com.netflix.usuario.application.usecase.GetMinhaListaCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/minhaLista")
@RestController
public class MinhaListaController {

    private final GetMinhaListaCase getMinhaListaCase;

    public MinhaListaController(GetMinhaListaCase getMinhaListaCase){
        this.getMinhaListaCase= getMinhaListaCase;
    }

    @PostMapping("listarfilme")
    public ResponseEntity listarFilme (@RequestHeader Map<String, String> headers,
                                       @RequestBody MinhaLista minhaLista) {
        String userId = headers.get("user-id");
        minhaLista.getUserId();
        getMinhaListaCase.listarFilme(minhaLista);

        return ResponseEntity.ok().build();
    }

}
