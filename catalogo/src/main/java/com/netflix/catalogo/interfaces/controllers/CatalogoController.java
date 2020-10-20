package com.netflix.catalogo.interfaces.controllers;

import com.netflix.catalogo.application.services.domains.Catalogo;
import com.netflix.catalogo.application.usecases.GetCatalogoUseCase;
import com.netflix.catalogo.repositories.entities.enums.GeneroEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/catalogos")
@RestController
public class CatalogoController {

    private final GetCatalogoUseCase getCatalogoUseCase;

    public CatalogoController(GetCatalogoUseCase getCatalogoUseCase) {
        this.getCatalogoUseCase = getCatalogoUseCase;
    }

    @GetMapping("{genero}")
    public List<Catalogo> get(@PathVariable("{genero}") GeneroEnum genero) {
        List<Catalogo> catalogos = getCatalogoUseCase.getByGenero(genero);
        return catalogos;
    }

    @GetMapping("{id}")
    public Catalogo get(@PathVariable("id") Long id) throws Exception {
        Catalogo catalogo = getCatalogoUseCase.getById(id);
        return catalogo;
    }
}
