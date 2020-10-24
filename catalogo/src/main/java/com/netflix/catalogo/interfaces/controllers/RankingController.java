package com.netflix.catalogo.interfaces.controllers;

import com.netflix.catalogo.application.services.domains.Catalogo;
import com.netflix.catalogo.application.services.domains.Ranking;
import com.netflix.catalogo.application.usecases.GetCatalogoUseCase;
import com.netflix.catalogo.application.usecases.GetRankingUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RequestMapping("/rankings")
@RestController
public class RankingController {

    private final GetCatalogoUseCase getCatalogoUseCase;

    private final GetRankingUseCase getRankingUseCase;

    public RankingController(GetCatalogoUseCase getCatalogoUseCase, GetRankingUseCase getRankingUseCase) {
        this.getCatalogoUseCase = getCatalogoUseCase;
        this.getRankingUseCase = getRankingUseCase;
    }


    @PostMapping("{id}/votar")
    public ResponseEntity votar(
            @RequestHeader Map<String, String> headers,
            @PathVariable("id") Long id,
            @RequestBody Ranking ranking) throws Exception {

        String userId = headers.get("userId");

        Optional<Catalogo> catalogoOptional = getCatalogoUseCase.getById(id);

        catalogoOptional.ifPresent(catalogo -> {
            ranking.setUsuarioId(Long.getLong(userId));
            ranking.setCatalogo(catalogo);

            getRankingUseCase.votar(ranking);
        });

        return ResponseEntity.ok().build();
    }

}
