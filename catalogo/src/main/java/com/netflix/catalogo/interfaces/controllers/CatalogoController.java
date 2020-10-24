package com.netflix.catalogo.interfaces.controllers;

import com.netflix.catalogo.application.services.domains.Catalogo;
import com.netflix.catalogo.application.usecases.GetCatalogoUseCase;
import com.netflix.catalogo.interfaces.controllers.dtos.CategoriaRatedDTO;
import com.netflix.catalogo.repositories.entities.enums.GeneroEnum;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/catalogos")
@RestController
public class CatalogoController {

    private final GetCatalogoUseCase getCatalogoUseCase;


    public CatalogoController(GetCatalogoUseCase getCatalogoUseCase) {
        this.getCatalogoUseCase = getCatalogoUseCase;
    }

    @GetMapping
    public List<Catalogo> findAll(@RequestParam(value = "genero", required = false) GeneroEnum genero
                            , @RequestParam(value = "palavra-chave", required = false) String palavraChave) {

        List<Catalogo> catalogos = getCatalogoUseCase.getByGeneroOuPalavraChave(genero, palavraChave);
        return catalogos;
    }

    @GetMapping("{id}")
    public Catalogo get(@PathVariable("id") Long id) throws Exception {
        Optional<Catalogo> catalogo = getCatalogoUseCase.getById(id);
        return catalogo.orElseThrow(() -> new RuntimeException("Catalogo não existe."));
    }

    public List<CategoriaRatedDTO> findAllMostRatedByGenero(@RequestParam(value = "genero", required = false) GeneroEnum genero){

        getCatalogoUseCase.findAllMostRatedByGeneroUseCase();

        return null;
    }
}