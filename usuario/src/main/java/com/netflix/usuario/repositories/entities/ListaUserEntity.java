package com.netflix.usuario.repositories.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="minha_lista", schema = "fiap")
public class ListaUserEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idLista;

    @ManyToOne
    @JoinColumn(name="usuario_id", nullable=false)
    private UsuarioEntity usuarioEntity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "catalogo_sumarizado_id", referencedColumnName = "id")
    private CatalogoSumarizadoEntity filme;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEscolha;

    private boolean visualizacaoFutura = true;

    public ListaUserEntity() {
    }

    public Long getIdLista() {
        return idLista;
    }

    public void setIdLista(Long idLista) {
        this.idLista = idLista;
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

    public boolean getVisualizacaoFutura() {
        return visualizacaoFutura;
    }

    public void setVisualizacaoFutura(boolean visualizacaoFutura) {
        this.visualizacaoFutura = visualizacaoFutura;
    }
}
