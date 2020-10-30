package com.netflix.usuario.application.services.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.netflix.usuario.repositories.entities.UsuarioEntity;

import java.io.Serializable;
import java.util.Date;

public class Historico implements Serializable {

    private Long id;
    @JsonIgnore
    private UsuarioEntity userId;
    @JsonIgnore
    private CatalagoSumarizado filme;
    private Date criacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsuarioEntity getUserId() {
        return userId;
    }

    public void setUserId(UsuarioEntity userId) {
        this.userId = userId;
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
