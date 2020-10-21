package com.netflix.catalogo.repositories.entities;

import javax.persistence.*;

@Entity
@Table(name="ranking", schema = "fiap")
public class RankingEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="catalogo_id", nullable=false)
    private CatalogoEntity catalogoEntity;

    private Long usuarioId;

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
}
