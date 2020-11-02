package com.netflix.usuario.repositories.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.netflix.usuario.application.services.domains.CatalogoSumarizado;
import com.netflix.usuario.application.services.domains.Usuario;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="historico", schema = "fiap")
public class HistoricoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="usuario_id", nullable=false)
    private UsuarioEntity usuarioEntity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "catalogo_sumarizado_id", referencedColumnName = "id")
    private CatalogoSumarizadoEntity filme;

    @Temporal(TemporalType.TIMESTAMP)
    private Date criacao;

    public HistoricoEntity(){

    }
    public HistoricoEntity(UsuarioEntity usuarioEntity, Long usuarioId,
                           CatalogoSumarizadoEntity catalogoSumarizadoEntity, Long filme,
                           Date criacao){
        this.usuarioEntity=usuarioEntity;
        this.filme=catalogoSumarizadoEntity;
        this.criacao=criacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsuarioEntity getUsuarioEntity() {
        return usuarioEntity;
    }

    public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
        this.usuarioEntity = usuarioEntity;
    }

    public CatalogoSumarizadoEntity getFilme() {
        return filme;
    }

    public void setFilme(CatalogoSumarizadoEntity filme) {
        this.filme = filme;
    }

    public Date getCriacao() {
        return criacao;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public void setCriacao(Date criacao) {
        this.criacao = criacao;
    }
}
