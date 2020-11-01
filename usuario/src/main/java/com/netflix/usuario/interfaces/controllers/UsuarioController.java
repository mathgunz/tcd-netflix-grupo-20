package com.netflix.usuario.interfaces.controllers;

import com.netflix.usuario.application.services.UsuarioService;
import com.netflix.usuario.application.services.domains.Response;
import com.netflix.usuario.application.services.domains.Usuario;
import com.netflix.usuario.application.usecase.GetUsuarioUseCase;
import com.netflix.usuario.interfaces.controllers.dtos.MinhaListaDTO;
import com.netflix.usuario.repositories.entities.HistoricoEntity;
import com.netflix.usuario.repositories.entities.MinhaListaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final GetUsuarioUseCase getUsuarioUseCase;
    private UsuarioService usuarioService;

    public UsuarioController(GetUsuarioUseCase getUsuarioUseCase){
        this.getUsuarioUseCase = getUsuarioUseCase;

    }

    //METODO BUSCAR ID USUARIO
    @GetMapping("{id}")
    public Usuario get(@PathVariable(value="id") Long id) throws Exception {
        Optional<Usuario> user= getUsuarioUseCase.getById(id);
        return user.orElseThrow(() -> new RuntimeException("Usuário não existe."));
    }

    //METODO PARA SALVAR FILME PARA SER VISTO DEPOIS
    @PostMapping(path="/saveFilm")
    public ResponseEntity<Response<MinhaListaEntity>> salvar(@Validated @RequestBody MinhaListaDTO minhaListaDTO,
                                                             BindingResult result) {
        Response<MinhaListaEntity> response = new Response<MinhaListaEntity>();

        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        MinhaListaEntity filmeSalvo = this.usuarioService.salvarFilme(minhaListaDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(minhaListaDTO.getId())
                .toUri();
        response.setUser(filmeSalvo);
        return ResponseEntity.created(location).body(response);
    }

    //MÉTODO PARA LISTAR HISTORICO DO USUARIO
    @GetMapping(path="/historico")
        public ResponseEntity<List<HistoricoEntity>> listarHistorico(){
            List<HistoricoEntity> historicoEntities = usuarioService.listarHistorico();
            return ResponseEntity.status(HttpStatus.OK).body(historicoEntities);
        }

}