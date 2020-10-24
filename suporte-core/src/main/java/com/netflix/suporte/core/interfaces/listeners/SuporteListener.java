package com.netflix.suporte.core.interfaces.listeners;

import com.netflix.suporte.core.application.domains.Suporte;
import com.netflix.suporte.core.application.usecases.SuporteUseCase;

public class SuporteListener {

    private final SuporteUseCase suporteUseCase;

    public SuporteListener(SuporteUseCase suporteUseCase) {
        this.suporteUseCase = suporteUseCase;
    }

    //    @Listener
    public void receberChamado(Suporte suporte) {

        suporteUseCase.abrirChamado(suporte);

    }
}