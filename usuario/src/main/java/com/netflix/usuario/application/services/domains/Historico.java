package com.netflix.usuario.application.services.domains;

import com.netflix.usuario.repositories.entities.CatalogoSumarizadoEntity;
import com.netflix.usuario.repositories.entities.UsuarioEntity;

import java.io.Serializable;
import java.util.Date;

public class Historico implements Serializable {
    private Long id;
    private UsuarioEntity usuarioEntity;
    private CatalogoSumarizadoEntity filme;
    private Date criacao;

    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsuarioEntity getUsuarioEntity(){
        return usuarioEntity;
    }

    public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
        this.usuarioEntity = usuarioEntity;
    }

    public CatalogoSumarizadoEntity getCatalogoSumarizadoEntity() {
        return filme;
    }

    public void setCatalogoSumarizadoEntity(CatalogoSumarizadoEntity filme) {
        this.filme = filme;
    }

    public Date criaca(){
        return criacao;

    }

    public void setCriacao(Date criacao) {
        this.criacao = criacao;
    }
}
