package com.netflix.usuario.repositories.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="usuario", schema = "fiap")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;

    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    private String email;

    @OneToMany(mappedBy="usuarioEntity", cascade = CascadeType.ALL)
    private List<MinhaListaEntity> minhalista;

    @OneToMany(mappedBy="usuarioEntity", cascade = CascadeType.ALL)
    private List<HistoricoEntity> historicos;

    private Date criacao;

    public UsuarioEntity() {
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<MinhaListaEntity> getMinhalista() {
        return minhalista;
    }

    public void setMinhalista(List<MinhaListaEntity> minhalista) {
        this.minhalista = minhalista;
    }

    public List<HistoricoEntity> getHistoricos() {
        return historicos;
    }

    public void setHistoricos(List<HistoricoEntity> historicos) {
        this.historicos = historicos;
    }

    public Date getCriacao() {
        return criacao;
    }

    public void setCriacao(Date criacao) {
        this.criacao = criacao;
    }
}



