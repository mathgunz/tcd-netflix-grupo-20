package com.netflix.usuario.interfaces.controllers.dtos;

import com.netflix.usuario.application.services.domains.Usuario;

import java.util.List;

public class UsuarioDTO {

    private List<Usuario> usuarios;

    public List<Usuario> getUsuarios(){
        return usuarios;
    }
    public void setUsuarios(List<Usuario> usuarios){
        this.usuarios=usuarios;
    }
}
