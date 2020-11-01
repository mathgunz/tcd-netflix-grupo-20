package com.netflix.usuario.application.services.domains;

import java.io.Serializable;
import java.util.Date;

public class Historico  implements Serializable {

    private Long id;
    private Long usuarioId;
    private Long filme;
    private Date criacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioEntity() {
        return usuarioId;
    }

    public void setUsuarioEntity(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getFilme() {
        return filme;
    }

    public void setFilme(Long filme) {
        this.filme = filme;
    }

    public Date getCriacao() {
        return criacao;
    }

    public void setCriacao(Date criacao) {
        this.criacao = criacao;
    }
}
