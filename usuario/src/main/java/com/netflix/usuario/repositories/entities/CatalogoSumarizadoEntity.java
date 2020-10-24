package com.netflix.usuario.repositories.entities;

import javax.persistence.*;

@Entity
@Table(name="usuario", schema = "fiap")
public class CatalogoSumarizadoEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Long catalogoId;
    private String nome;
    private String imagemCapa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImagemCapa() {
        return imagemCapa;
    }

    public void setImagemCapa(String imagemCapa) {
        this.imagemCapa = imagemCapa;
    }

    public Long getCatalogoId() {
        return catalogoId;
    }

    public void setCatalogoId(Long catalogoId) {
        this.catalogoId = catalogoId;
    }
}
