package com.netflix.catalogo.interfaces.controllers.dtos;

import java.util.List;

public class CategoriaRatedDTO {

    private List<GeneroDTO> generos;

    public List<GeneroDTO> getGeneros() {
        return generos;
    }

    public void setGeneros(List<GeneroDTO> generos) {
        this.generos = generos;
    }
}
