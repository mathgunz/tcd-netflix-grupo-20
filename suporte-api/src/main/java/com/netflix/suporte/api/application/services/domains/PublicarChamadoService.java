package com.netflix.suporte.api.application.services.domains;

import com.netflix.suporte.api.application.usecases.PublicarChamadoUseCase;
import com.netflix.suporte.api.interfaces.controllers.dtos.SuporteDto;
import org.springframework.stereotype.Service;

@Service
public class PublicarChamadoService implements PublicarChamadoUseCase {
    @Override
    public void publicar(SuporteDto suporte) {

        //publicar

    }
}
