package com.netflix.usuario.application.services.domains;

import java.io.Serializable;
import java.util.Date;

public class MinhaLista implements Serializable {

    private Long id;
    private Long usuarioId;
    private Long filme;
    private Date dataEscolha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getFilme() {
        return filme;
    }

    public void setFilme(Long filme) {
        this.filme = filme;
    }

    public Date getDataEscolha() {
        return dataEscolha;
    }

    public void setDataEscolha(Date dataEscolha) {
        this.dataEscolha = dataEscolha;
    }

}
