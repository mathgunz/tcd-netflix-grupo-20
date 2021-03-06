package com.netflix.usuario.repositories.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;


@Entity(name = "minhaLista")
@Table(name="minha_lista", schema = "usuario_fiap")
public class MinhaListaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity usuarioEntity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "catalogo_sumarizado_id", referencedColumnName = "id")
    private CatalogoSumarizadoEntity filme;

    @Temporal(TemporalType.DATE)
    private Date dataEscolha;

    public MinhaListaEntity(){

    }

    public MinhaListaEntity(UsuarioEntity usuarioEntity,
                            CatalogoSumarizadoEntity catalogoSumarizadoEntity, Date dataEscolha) {
        this.usuarioEntity=usuarioEntity;
        this.filme=catalogoSumarizadoEntity;
        this.dataEscolha=dataEscolha;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public void setDataEscolha(Date dataEscolha) {
        this.dataEscolha = dataEscolha;
    }
}