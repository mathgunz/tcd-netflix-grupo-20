package com.netflix.suporte.core.repositories.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="suporte", schema = "fiap")
public class SuporteEntiy {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Long usuarioId;

    private String descricao;

    private String tipo;

    @Temporal(TemporalType.TIMESTAMP)
    private Date criacao;

    public SuporteEntiy() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getCriacao() {
        return criacao;
    }

    public void setCriacao(Date criacao) {
        this.criacao = criacao;
    }
}
