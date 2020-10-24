package com.netflix.suporte.api.application.usecases;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.netflix.suporte.api.interfaces.controllers.dtos.SuporteDto;

public interface PublicarChamadoUseCase {

    public void publicar(SuporteDto suporte);

}
