package com.netflix.catalogo.interfaces.controllers.dtos;

import com.netflix.catalogo.application.services.domains.Catalogo;

import java.util.List;

public class GeneroDTO {

    private String tipo;

    private List<Catalogo> catalogos;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Catalogo> getCatalogos() {
        return catalogos;
    }

    public void setCatalogos(List<Catalogo> catalogos) {
        this.catalogos = catalogos;
    }
}
