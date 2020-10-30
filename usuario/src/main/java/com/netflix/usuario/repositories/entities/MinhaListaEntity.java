package com.netflix.usuario.repositories.entities;

import com.netflix.usuario.application.services.domains.Usuario;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="minha_lista", schema = "fiap")
public class MinhaListaEntity {

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
    private Date dataEscolha;

    public MinhaListaEntity(){
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

    public Date getDataEscolha() {
        return dataEscolha;
    }

    public void setDataEscolha(Date dataEscolha) {
        this.dataEscolha = dataEscolha;
    }

}
