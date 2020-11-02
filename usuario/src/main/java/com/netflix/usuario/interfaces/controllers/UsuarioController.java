package com.netflix.usuario.interfaces.controllers;

import com.netflix.usuario.application.services.domains.MinhaLista;
import com.netflix.usuario.application.services.domains.Usuario;
import com.netflix.usuario.application.usecase.GetUsuarioUseCase;
import com.netflix.usuario.repositories.entities.HistoricoEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping
public class UsuarioController {

    private final GetUsuarioUseCase getUsuarioUseCase;

    public UsuarioController(GetUsuarioUseCase getUsuarioUseCase){
        this.getUsuarioUseCase = getUsuarioUseCase;

    }

    //METODO BUSCAR ID USUARIO
    @GetMapping("usuario/{id}")
    public Usuario get(@PathVariable(value="id") Long id) throws Exception {
        Optional<Usuario> user= getUsuarioUseCase.getById(id);
        return user.orElseThrow(() -> new RuntimeException("Usuário não existe."));
    }

    //LISTAR HISTORICO DO USUARIO
    @GetMapping("historicos")
    public List<HistoricoDTO> findAllHistorico(HttpServletRequest request){

        Principal principal = request.getUserPrincipal();

        List<HistoricoEntity> historicos = getUsuarioUseCase.findAllHistorico(principal.getName());

        List<HistoricoDTO> historicosDto = historicos.stream().map(historicoEntity ->
              new HistoricoDTO(historicoEntity.getId(),
              new CatalogoSumarizadoDTO(historicoEntity.getFilme().getId(),
                      historicoEntity.getFilme().getCatalogoId(),
                      historicoEntity.getFilme().getNome(),
                      historicoEntity.getFilme().getImagemCapa()),
              historicoEntity.getCriacao())).collect(Collectors.toList());

        return historicosDto;
    }

    //SALVAR FILME PARA SER VISTO DEPOIS
    @PostMapping("minha-lista/salvar")
    public ResponseEntity salvar(
            HttpServletRequest request,
            @RequestBody MinhaLista minhaLista) throws Exception {

        Principal principal = request.getUserPrincipal();

        getUsuarioUseCase.salvar(principal.getName(), minhaLista);

        return ResponseEntity.ok().build();
    }
}
