package com.netflix.usuario.interfaces.controllers;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

public class HistoricoDTO implements Serializable {

    private Long id;

    private CatalogoSumarizadoDTO filme;

    @Temporal(TemporalType.TIMESTAMP)
    private Date criacao;

    public HistoricoDTO(Long id, CatalogoSumarizadoDTO filme, Date criacao) {
        this.id = id;
        this.filme = filme;
        this.criacao = criacao;
    }

    public HistoricoDTO(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CatalogoSumarizadoDTO getFilme() {
        return filme;
    }

    public void setFilme(CatalogoSumarizadoDTO filme) {
        this.filme = filme;
    }

    public Date getCriacao() {
        return criacao;
    }

    public void setCriacao(Date criacao) {
        this.criacao = criacao;
    }
}
