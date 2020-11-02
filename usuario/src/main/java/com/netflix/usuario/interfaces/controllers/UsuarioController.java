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
    public List<HistoricoDTO> findAllHistorico (){
      List<HistoricoEntity> historicos = getUsuarioUseCase.findAllHistorico();

      List<HistoricoDTO> historicosDto = historicos.stream().map(historicoEntity ->
              new HistoricoDTO(historicoEntity.getId(),
              new UsuarioDTO(historicoEntity.getUsuarioEntity().getNome(), historicoEntity.getUsuarioEntity().getTipoConta()),
              new CatalogoSumarizadoDTO(historicoEntity.getFilme().getId(),
                      historicoEntity.getFilme().getCatalogoId(),
                      historicoEntity.getFilme().getNome(),
                      historicoEntity.getFilme().getImagemCapa()),
              historicoEntity.getCriacao())).collect(Collectors.toList());

      return historicosDto;
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
