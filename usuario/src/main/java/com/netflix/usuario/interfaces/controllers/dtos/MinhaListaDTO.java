package com.netflix.usuario.interfaces.controllers.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.netflix.usuario.application.services.domains.CatalagoSumarizado;
import com.netflix.usuario.application.services.domains.Usuario;
import com.netflix.usuario.repositories.entities.CatalogoSumarizadoEntity;

import java.io.Serializable;
import java.util.Date;

public class MinhaListaDTO implements Serializable {

    private Long id;
    private Long userId;
    private Long filme;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dataEscolha;

    public MinhaListaDTO(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
