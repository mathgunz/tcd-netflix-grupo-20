package com.netflix.usuario.interfaces.controllers;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

public class HistoricoDTO implements Serializable {

    private Long id;

    private UsuarioDTO usuario;

    private CatalogoSumarizadoDTO filme;

    @Temporal(TemporalType.TIMESTAMP)
    private Date criacao;

    public HistoricoDTO(Long id, UsuarioDTO usuario, CatalogoSumarizadoDTO filme, Date criacao) {
        this.id = id;
        this.usuario = usuario;
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

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
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
