package com.netflix.usuario.application.services;

import com.netflix.usuario.application.services.domains.Historico;
import com.netflix.usuario.application.usecase.GetHistoricoCase;
import com.netflix.usuario.repositories.entities.HistoricoEntity;
import com.netflix.usuario.repositories.entities.HistoricoRepository;
import com.netflix.usuario.repositories.entities.UsuarioEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoricoService implements GetHistoricoCase {

    private final HistoricoRepository historicoRepository;

    public HistoricoService(HistoricoRepository historicoRepository){
        this.historicoRepository = historicoRepository;
    }

    @Override
    public List<HistoricoEntity> findAllHistoricalByIdUser(){
        List<HistoricoEntity> historicoRepositoryAll = historicoRepository.findAll();
        return null;
    }
}
