package com.netflix.catalogo.application.usecases;

import com.netflix.catalogo.application.services.domains.Catalogo;
import com.netflix.catalogo.repositories.entities.enums.GeneroEnum;

import java.util.List;

public interface GetCatalogoUseCase {

    List<Catalogo> getByGenero(GeneroEnum genero);

    Catalogo getById(Long id) throws Exception;
}
