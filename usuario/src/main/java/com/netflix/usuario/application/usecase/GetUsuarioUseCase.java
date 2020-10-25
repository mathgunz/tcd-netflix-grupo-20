package com.netflix.usuario.application.usecase;

import com.netflix.usuario.application.services.domains.ListaUser;
import com.netflix.usuario.application.services.domains.Usuario;
import com.netflix.usuario.repositories.entities.HistoricoEntity;


import java.util.List;
import java.util.Optional;

public interface GetUsuarioUseCase {

    List<HistoricoEntity> findAllHistorico();

    Optional<Usuario> getByIdUser(Long idUser) throws Exception;

    void assistirFuturamente(ListaUser listaUser);
}



