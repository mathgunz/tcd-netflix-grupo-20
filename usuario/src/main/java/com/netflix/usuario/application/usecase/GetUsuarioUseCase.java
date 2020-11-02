package com.netflix.usuario.application.usecase;

import com.netflix.usuario.application.services.domains.MinhaLista;
import com.netflix.usuario.application.services.domains.Usuario;
import com.netflix.usuario.repositories.entities.HistoricoEntity;

import java.util.List;
import java.util.Optional;

public interface GetUsuarioUseCase {

    Optional<Usuario> getById(Long id) throws Exception;

    void salvar (String userName ,MinhaLista minhaLista);

    List<HistoricoEntity> findAllHistorico(String userName);
}
