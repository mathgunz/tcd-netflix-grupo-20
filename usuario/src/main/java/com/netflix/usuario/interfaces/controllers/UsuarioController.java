package com.netflix.usuario.interfaces.controllers;

import com.netflix.usuario.application.services.domains.MinhaLista;
import com.netflix.usuario.application.services.domains.Usuario;
import com.netflix.usuario.application.usecase.GetUsuarioUseCase;
import com.netflix.usuario.repositories.entities.HistoricoEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final GetUsuarioUseCase getUsuarioUseCase;

    public UsuarioController(GetUsuarioUseCase getUsuarioUseCase){
        this.getUsuarioUseCase = getUsuarioUseCase;

    }

    //METODO BUSCAR ID USUARIO
    @GetMapping("{id}")
    public Usuario get(@PathVariable(value="id") Long id) throws Exception {
        Optional<Usuario> user= getUsuarioUseCase.getById(id);
        return user.orElseThrow(() -> new RuntimeException("Usuário não existe."));
    }

    //LISTAR HISTORICO DO USUARIO
    @GetMapping
    public List<HistoricoEntity> findAllHistorico (@RequestParam(value = "id", required = false) Long id){
      List<HistoricoEntity> historicos = getUsuarioUseCase.findAllHistorico();
      return historicos;
    }

    //SALVAR FILME PARA SER VISTO DEPOIS
    @PostMapping("/salvar")
    public ResponseEntity salvar(
            @RequestHeader Map<String, String> headers,
            @RequestBody MinhaLista minhaLista) throws Exception {
        getUsuarioUseCase.salvar(minhaLista);
        return ResponseEntity.ok().build();
    }
}
