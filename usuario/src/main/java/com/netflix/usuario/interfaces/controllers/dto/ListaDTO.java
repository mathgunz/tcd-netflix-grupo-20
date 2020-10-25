package com.netflix.usuario.interfaces.controllers.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.netflix.usuario.application.services.domains.ListaUser;
import com.netflix.usuario.application.services.domains.Usuario;
import com.netflix.usuario.repositories.entities.CatalogoSumarizadoEntity;

import java.io.Serializable;
import java.util.Date;


public class ListaDTO extends ListaUser implements Serializable {

    private Long idUser;
    private CatalogoSumarizadoEntity catalogoId;
    private Boolean visualizacaoFutura;
    private Date dataEscolha;

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public CatalogoSumarizadoEntity getCatalogoId() {
        return catalogoId;
    }

    public void setCatalogoId(CatalogoSumarizadoEntity catalogoId) {
        this.catalogoId = catalogoId;
    }

    public Boolean getVisualizacaoFutura() {
        return visualizacaoFutura;
    }

    public void setVisualizacaoFutura(Boolean visualizacaoFutura) {
        this.visualizacaoFutura = visualizacaoFutura;
    }

    public Date getDataEscolha() {
        return dataEscolha;
    }

    public void setDataEscolha(Date dataEscolha) {
        this.dataEscolha = dataEscolha;
    }
}
