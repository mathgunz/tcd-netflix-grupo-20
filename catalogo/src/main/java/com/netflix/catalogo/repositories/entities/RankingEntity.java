package com.netflix.catalogo.repositories.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="ranking", schema = "catalogo-fiap")
public class RankingEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="catalogo_id", nullable=false)
    private CatalogoEntity catalogoEntity;

    private Long usuarioId;

    private boolean gostou = true;

    @Temporal(TemporalType.TIMESTAMP)
    private Date criacao;

    public RankingEntity() {
    }

    public RankingEntity(CatalogoEntity catalogoEntity, Long usuarioId) {

        this.catalogoEntity = catalogoEntity;
        this.usuarioId = usuarioId;
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

    public CatalogoEntity getCatalogoEntity() {
        return catalogoEntity;
    }

    public void setCatalogoEntity(CatalogoEntity catalogoEntity) {
        this.catalogoEntity = catalogoEntity;
    }

    public boolean isGostou() {
        return gostou;
    }

    public void setGostou(boolean gostou) {
        this.gostou = gostou;
    }

    public Date getCriacao() {
        return criacao;
    }

    public void setCriacao(Date criacao) {
        this.criacao = criacao;
    }
}
