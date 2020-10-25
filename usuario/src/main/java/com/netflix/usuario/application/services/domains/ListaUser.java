package com.netflix.usuario.application.services.domains;

import com.netflix.usuario.repositories.entities.CatalogoSumarizadoEntity;
import com.netflix.usuario.repositories.entities.UsuarioEntity;

import java.io.Serializable;
import java.util.Date;

public class ListaUser implements Serializable {

    private Long idLista;
    private UsuarioEntity usuarioEntity;
    private CatalogoSumarizadoEntity filme;
    private Date dataEscolha;
    private boolean visualizacaoFutura;


    public Long getIdLista() {
        return idLista;
    }

    public void setIdLista(Long idLista) {
        this.idLista = idLista;
    }

    public UsuarioEntity getUsuarioEntity() {
        return usuarioEntity;
    }

    public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
        this.usuarioEntity = usuarioEntity;
    }

    public CatalogoSumarizadoEntity getFilme() {
        return filme;
    }

    public void setFilme(CatalogoSumarizadoEntity filme) {
        this.filme = filme;
    }

    public Date getDataEscolha() {
        return dataEscolha;
    }

    public void setDataEscolha(Date dataEscolha) {
        this.dataEscolha = dataEscolha;
    }

    public boolean isVisualizacaoFutura() {
        return visualizacaoFutura;
    }

    public void setVisualizacaoFutura(boolean visualizacaoFutura) {
        this.visualizacaoFutura = visualizacaoFutura;
    }
}

