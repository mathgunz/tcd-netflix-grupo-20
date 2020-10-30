package com.netflix.usuario.application.services;

import com.netflix.usuario.application.services.domains.MinhaLista;
import com.netflix.usuario.application.usecase.GetMinhaListaCase;
import com.netflix.usuario.repositories.entities.MinhaListaEntity;
import com.netflix.usuario.repositories.entities.MinhaListaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MinhaListaService implements GetMinhaListaCase {

    private final MinhaListaRepository minhaListaRepository;

    public MinhaListaService(MinhaListaRepository minhaListaRepository) {
        this.minhaListaRepository = minhaListaRepository;
    }

    @Override
    public void listarFilme(MinhaLista minhaLista) {

        MinhaListaEntity minhaListaEntity = new MinhaListaEntity();
        minhaListaEntity.setUsuarioEntity(minhaListaEntity.getUsuarioEntity());
        minhaListaEntity.setFilme(minhaListaEntity.getFilme());
        minhaListaEntity.setDataEscolha(new Date());

        minhaListaRepository.save(minhaListaEntity);

    }
}
