package com.netflix.usuario.application.services.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.netflix.usuario.repositories.entities.UsuarioEntity;

import java.io.Serializable;
import java.util.Date;

public class MinhaLista implements Serializable {

    private Long id;
    @JsonIgnore
    private UsuarioEntity userId;
    @JsonIgnore
    private CatalagoSumarizado filme;
    private Date dataEscolha;

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

    public Date getDataEscolha() {
        return dataEscolha;
    }

    public void setDataEscolha(Date dataEscolha) {
        this.dataEscolha = dataEscolha;
    }


}
