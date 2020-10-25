package com.netflix.catalogo.application.services.domains;

import com.netflix.catalogo.repositories.entities.enums.CategoriaEnum;
import com.netflix.catalogo.repositories.entities.enums.GeneroEnum;
import java.io.Serializable;

public class Catalogo implements Serializable {

    private Long id;
    private String nome;
    private String descricao;
    private GeneroEnum generoType;
    private CategoriaEnum categoria;
    private String direcao;
    private String urlFilme;
    private String capa;
    private String elenco;
    private Long classificacaoEtaria;

    public Long getId() { return id; }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public GeneroEnum getGeneroType() {
        return generoType;
    }

    public CategoriaEnum getCategoria() {
        return categoria;
    }

    public String getDirecao() {
        return direcao;
    }

    public String getUrlFilme() {
        return urlFilme;
    }

    public String getCapa() {
        return capa;
    }

    public String getElenco() {
        return elenco;
    }

    public Long getClassificacaoEtaria() {
        return classificacaoEtaria;
    }

    private Catalogo(Builder builder) {
        id = builder.id;
        nome = builder.nome;
        descricao = builder.descricao;
        generoType = builder.generoType;
        categoria = builder.categoria;
        direcao = builder.direcao;
        urlFilme = builder.urlFilme;
        capa = builder.capa;
        elenco = builder.elenco;
        classificacaoEtaria = builder.classificacaoEtaria;
    }

    public static Builder newBuilder() { return new Builder(); }

    public static Builder newBuilder(Catalogo copy) {
        Builder builder = new Builder();
        builder.id = copy.getId();
        builder.nome = copy.getNome();
        builder.descricao = copy.getDescricao();
        builder.generoType = copy.getGeneroType();
        builder.categoria = copy.getCategoria();
        builder.direcao = copy.getDirecao();
        builder.urlFilme = copy.getUrlFilme();
        builder.capa = copy.getCapa();
        builder.elenco = copy.getElenco();
        builder.classificacaoEtaria = copy.getClassificacaoEtaria();
        return builder;
    }


    public static final class Builder {
        private Long id;
        private String nome;
        private String descricao;
        private GeneroEnum generoType;
        private CategoriaEnum categoria;
        private String direcao;
        private String urlFilme;
        private String capa;
        private String elenco;
        private Long classificacaoEtaria;

        private Builder() {
        }

        public Builder withId(Long val) {
            id = val;
            return this;
        }

        public Builder withNome(String val) {
            nome = val;
            return this;
        }

        public Builder withDescricao(String val) {
            descricao = val;
            return this;
        }

        public Builder withGeneroType(GeneroEnum val) {
            generoType = val;
            return this;
        }

        public Builder withCategoria(CategoriaEnum val) {
            categoria = val;
            return this;
        }

        public Builder withDirecao(String val) {
            direcao = val;
            return this;
        }

        public Builder withUrlFilme(String val) {
            urlFilme = val;
            return this;
        }

        public Builder withCapa(String val) {
            capa = val;
            return this;
        }

        public Builder withElenco(String val) {
            elenco = val;
            return this;
        }

        public Builder withClassificacaoEtaria(Long val) {
            classificacaoEtaria = val;
            return this;
        }

        public Catalogo build() {
            return new Catalogo(this);
        }
    }
}
