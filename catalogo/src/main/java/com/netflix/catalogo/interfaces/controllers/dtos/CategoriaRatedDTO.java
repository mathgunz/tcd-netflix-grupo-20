package com.netflix.catalogo.interfaces.controllers.dtos;

import com.netflix.catalogo.repositories.entities.CatalogoEntity;

import java.util.List;

public class CategoriaRatedDTO {

    private List<GeneroDTO> generos;

    public CategoriaRatedDTO(CatalogoEntity catalogoEntity) {
    }

    public List<GeneroDTO> getGeneros() {
        return generos;
    }

    public void setGeneros(List<GeneroDTO> generos) {
        this.generos = generos;
    }
}
