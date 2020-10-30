package com.netflix.usuario.interfaces.controllers;

import com.netflix.usuario.application.services.domains.Historico;
import com.netflix.usuario.application.services.domains.Usuario;
import com.netflix.usuario.application.usecase.GetHistoricoCase;
import com.netflix.usuario.interfaces.controllers.dtos.UsuarioDTO;
import com.netflix.usuario.repositories.entities.HistoricoEntity;
import com.netflix.usuario.repositories.entities.UsuarioEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/historico")
@RestController
public class HistoricoController {

    private GetHistoricoCase getHistoricoCase;

    public HistoricoController (GetHistoricoCase getHistoricoCase){
        this.getHistoricoCase = getHistoricoCase;
    }

    //Lista Historico de filmes por usuarios
    public List<UsuarioDTO> findAllHistoricalByIdUser(@RequestParam(value = "id", required = false)
                                                      Usuario id){
        getHistoricoCase.findAllHistoricalByIdUser();
        return null;
    }
}
