package com.netflix.usuario.application.services.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

public class Historico implements Serializable {

    private Long id;
    private Usuario usuarioEntity;
    private CatalagoSumarizado filme;
    private Date criacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuarioEntity() {
        return usuarioEntity;
    }

    public void setUsuarioEntity(Usuario usuarioEntity) {
        this.usuarioEntity = usuarioEntity;
    }

    public CatalagoSumarizado getFilme() {
        return filme;
    }

    public void setFilme(CatalagoSumarizado filme) {
        this.filme = filme;
    }

    public Date getCriacao() {
        return criacao;
    }

    public void setCriacao(Date criacao) {
        this.criacao = criacao;
    }

}
