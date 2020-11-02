package com.netflix.usuario.interfaces.controllers;

import java.io.Serializable;

public class CatalogoSumarizadoDTO implements Serializable {
    private Long id;
    private Long catalogoId;
    private String nome;
    private String imagemCapa;

    public CatalogoSumarizadoDTO(Long id, Long catalogoId, String nome, String imagemCapa) {
        this.id = id;
        this.catalogoId = catalogoId;
        this.nome = nome;
        this.imagemCapa = imagemCapa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCatalogoId() {
        return catalogoId;
    }

    public void setCatalogoId(Long catalogoId) {
        this.catalogoId = catalogoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImagemCapa() {
        return imagemCapa;
    }

    public void setImagemCapa(String imagemCapa) {
        this.imagemCapa = imagemCapa;
    }
}
