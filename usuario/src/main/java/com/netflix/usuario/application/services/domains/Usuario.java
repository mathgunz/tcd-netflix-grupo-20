package com.netflix.usuario.application.services.domains;

import java.io.Serializable;
import java.util.Date;

public class Usuario implements Serializable {

    private Long idUser;
    private String nome;
    private String sobrenome;
    private String perfil;
    private String email;
    private String password;
    private Date criacao;
    private String tipoConta;


    public Long getIdUser()
    { return idUser; }

    public String getNome()
    { return nome; }

    public String getSobrenome()
    { return sobrenome; }

    public String getPerfil()
    { return perfil; }

    public String getEmail()
    { return email; }

    public String getPassword()
    { return email; }

    public Date getCriacao()
    { return criacao; }

    public String getTipoConta()
    { return tipoConta; }

    private Usuario(Builder builder){
        idUser= builder.idUser;
        nome= builder.nome;
        sobrenome = builder.sobrenome;
        perfil = builder.perfil;
        email = builder.email;
        password = builder.password;
        criacao = builder.criacao;
        tipoConta =builder.tipoConta;
        }

    public static Builder newBuilder()
    {
        return new Builder();
    }
    public static Builder newBuilder(Usuario copy){
        Builder builder = new Builder();
        builder.idUser = copy.getIdUser();
        builder.nome = copy.getNome();
        builder.sobrenome = copy.getSobrenome();
        builder.perfil=copy.getPerfil();
        builder.email=copy.getEmail();
        builder.password=copy.getPassword();
        builder.criacao=copy.getCriacao();
        builder.tipoConta=copy.getTipoConta();
        return builder;

    }
    public static final class Builder {
        private Long idUser;
        private String nome;
        private String sobrenome;
        private String perfil;
        private String email;
        private String password;
        private Date criacao;
        private String tipoConta;

        private  Builder(){

        }
            public Builder withIdUser(Long user) {
                idUser = user;
                return this;
            }

            public Builder withNome(String user) {
            nome = user;
            return this;
            }

            public Builder withSobrenome(String user) {
            sobrenome = user;
            return this;
            }

            public Builder withEmail(String user) {
            email = user;
            return this;
            }

            public Builder withPassword(String user) {
            password = user;
            return this;
            }

            public Builder withCriacao(Date user) {
            criacao = user;
            return this;
            }

            public Builder withTipoConta(String user) {
            tipoConta = user;
            return this;
            }
            public Usuario build() {
                return new Usuario(this);
            }

    }

}