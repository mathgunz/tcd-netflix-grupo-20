package com.netflix.catalogo.application.services.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class Ranking implements Serializable {

    private Long id;

    @JsonIgnore
    private Catalogo catalogo;

    private Long usuarioId;

    private boolean gostou;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public boolean isGostou() {
        return gostou;
    }

    public void setGostou(boolean gostou) {
        this.gostou = gostou;
    }
}
