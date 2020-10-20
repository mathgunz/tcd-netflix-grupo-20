package com.netflix.catalogo.repositories.entities.enums;

public enum CategoriaEnum {

    FILMES{
        @Override
        public String descricao() {
            return "Filmes";
        }
    },
    SERIES {
        @Override
        public String descricao() {
            return "Series";
        }
    },
    DOCUMENTARIOS {
        @Override
        public String descricao() {
            return "Documentários";
        }
    };

    public abstract String descricao();

}
