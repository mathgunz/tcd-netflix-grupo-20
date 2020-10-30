package com.netflix.usuario.application.usecase;

import com.netflix.usuario.application.services.domains.Historico;
import com.netflix.usuario.repositories.entities.HistoricoEntity;

import java.util.List;

public interface GetHistoricoCase  {

    List<HistoricoEntity> findAllHistoricalByIdUser();
}
