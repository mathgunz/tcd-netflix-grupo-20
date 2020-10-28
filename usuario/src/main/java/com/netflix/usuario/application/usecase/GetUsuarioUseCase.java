package com.netflix.usuario.application.usecase;

import com.netflix.usuario.application.services.domains.ListaUser;
import com.netflix.usuario.application.services.domains.Usuario;
import com.netflix.usuario.repositories.entities.HistoricoEntity;
import com.netflix.usuario.repositories.entities.UsuarioEntity;


import java.util.List;
import java.util.Optional;

public interface GetUsuarioUseCase {

    List<HistoricoEntity> findAll();

    Optional<Usuario> getById(Long id) throws Exception;

    void assistirFuturamente(ListaUser listaUser);
}



