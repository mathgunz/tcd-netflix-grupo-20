package com.netflix.usuario.application.services.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

public class MinhaLista implements Serializable {

    @JsonIgnore
    private Long id;

    private Long filme;
    private Date dataEscolha;
    private String nomeFilme;
    private String imagemCapaFilme;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public String getImagemCapaFilme() {
        return imagemCapaFilme;
    }

    public void setImagemCapaFilme(String imagemCapaFilme) {
        this.imagemCapaFilme = imagemCapaFilme;
    }
}
