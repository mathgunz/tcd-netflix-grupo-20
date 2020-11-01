package com.netflix.usuario.repositories.entities;

import com.netflix.usuario.application.services.domains.Usuario;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="historico", schema = "fiap")
public class HistoricoEntity {

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
    public HistoricoEntity(UsuarioEntity usuarioEntity, CatalogoSumarizadoEntity filme){
        this.usuarioEntity=usuarioEntity;
        this.filme=filme;
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

    public void setCriacao(Date criacao) {
        this.criacao = criacao;
    }
}
