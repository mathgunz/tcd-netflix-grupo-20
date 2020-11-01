package com.netflix.usuario.application.usecase;

import com.netflix.usuario.application.services.domains.Usuario;
import com.netflix.usuario.interfaces.controllers.dtos.MinhaListaDTO;
import com.netflix.usuario.repositories.entities.HistoricoEntity;
import com.netflix.usuario.repositories.entities.MinhaListaEntity;


import java.util.List;
import java.util.Optional;

public interface GetUsuarioUseCase {

    Optional<Usuario> getById(Long id) throws Exception;

    MinhaListaEntity salvarFilme (MinhaListaDTO minhaListaDTO);

    List<HistoricoEntity> listarHistorico();

}



