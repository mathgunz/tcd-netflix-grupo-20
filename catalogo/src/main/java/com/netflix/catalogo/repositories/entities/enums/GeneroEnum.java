package com.netflix.catalogo.repositories.entities.enums;

public enum GeneroEnum {

    ACAO{
        @Override
        public String descricao() {
            return "Ação";
        }
    },
    AVENTURA {
        @Override
        public String descricao() {
            return "Aventura";
        }
    },
    ANIMES {
        @Override
        public String descricao() {
            return "Animes";
        }
    },
    COMEDIA {
        @Override
        public String descricao() {
            return "Comédia";
        }
    },
    COMEDIA_ROMANTICA {
        @Override
        public String descricao() {
            return "Comédia Romantica";
        }
    },
    TERROR {
        @Override
        public String descricao() {
            return "Terror";
        }
    },
    DRAMA {
        @Override
        public String descricao() {
            return "Drama";
        }
    },
    SUSPENSE {
        @Override
        public String descricao() {
            return "Suspense";
        }
    };

    public abstract String descricao();

}
