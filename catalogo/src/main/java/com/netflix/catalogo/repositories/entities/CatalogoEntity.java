package com.netflix.catalogo.repositories.entities;

import com.netflix.catalogo.repositories.entities.enums.CategoriaEnum;
import com.netflix.catalogo.repositories.entities.enums.GeneroEnum;

import javax.persistence.*;
import java.util.List;

@Entity(name = "catalogo")
@Table(name="catalogo", schema = "catalogo-fiap")
public class CatalogoEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private GeneroEnum generoType;
    @Enumerated(EnumType.STRING)
    private CategoriaEnum categoria;
    private String direcao;
    private String urlFilme;
    private String capa;
    private String elenco;
    private Long classificacaoEtaria;

    @OneToMany(mappedBy="catalogoEntity", cascade = CascadeType.ALL)
    private List<RankingEntity> rankingEntity;

    public CatalogoEntity(String nome, String descricao, GeneroEnum generoType, CategoriaEnum categoria, String direcao, String urlFilme, String capa, String elenco, Long classificacaoEtaria) {
        this.nome = nome;
        this.descricao = descricao;
        this.generoType = generoType;
        this.categoria = categoria;
        this.direcao = direcao;
        this.urlFilme = urlFilme;
        this.capa = capa;
        this.elenco = elenco;
        this.classificacaoEtaria = classificacaoEtaria;
    }

    public CatalogoEntity() {
    }

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public GeneroEnum getGeneroType() {
        return generoType;
    }

    public void setGeneroType(GeneroEnum generoType) {
        this.generoType = generoType;
    }

    public CategoriaEnum getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEnum categoria) {
        this.categoria = categoria;
    }

    public String getDirecao() {
        return direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }

    public String getUrlFilme() {
        return urlFilme;
    }

    public void setUrlFilme(String urlFilme) {
        this.urlFilme = urlFilme;
    }

    public String getCapa() {
        return capa;
    }

    public void setCapa(String capa) {
        this.capa = capa;
    }

    public String getElenco() {
        return elenco;
    }

    public void setElenco(String elenco) {
        this.elenco = elenco;
    }

    public Long getClassificacaoEtaria() {
        return classificacaoEtaria;
    }

    public void setClassificacaoEtaria(Long classificacaoEtaria) {
        this.classificacaoEtaria = classificacaoEtaria;
    }

    public List<RankingEntity> getRankingEntity() {
        return rankingEntity;
    }

    public void setRankingEntity(List<RankingEntity> rankingEntity) {
        this.rankingEntity = rankingEntity;
    }
}
