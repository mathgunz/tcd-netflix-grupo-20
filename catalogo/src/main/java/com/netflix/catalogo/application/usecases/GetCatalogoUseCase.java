package com.netflix.catalogo.application.usecases;

import com.netflix.catalogo.application.services.domains.Catalogo;
import com.netflix.catalogo.repositories.entities.CatalogoEntity;
import com.netflix.catalogo.repositories.entities.enums.GeneroEnum;

import java.util.List;
import java.util.Optional;

public interface GetCatalogoUseCase {

    List<Catalogo> getByGeneroOuPalavraChave(GeneroEnum genero, String nome);

    Optional<Catalogo> getById(Long id) throws Exception;

    List<CatalogoEntity> findAllMostRatedByGeneroUseCase();
}
