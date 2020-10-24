package com.netflix.suporte.core.application.services.domains;

import com.netflix.suporte.core.application.domains.Suporte;
import com.netflix.suporte.core.application.usecases.SuporteUseCase;
import com.netflix.suporte.core.repositories.SuporteRepository;
import com.netflix.suporte.core.repositories.entities.SuporteEntiy;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SuporteService implements SuporteUseCase {

    private final SuporteRepository suporteRepository;

    public SuporteService(SuporteRepository suporteRepository) {
        this.suporteRepository = suporteRepository;
    }

    @Override
    public void abrirChamado(Suporte suporte) {

        SuporteEntiy suporteEntiy = new SuporteEntiy();
        suporteEntiy.setTipo(suporte.getTipo());
        suporteEntiy.setCriacao(new Date());
        suporteEntiy.setDescricao(suporte.getDescricao());
        suporteEntiy.setUsuarioId(suporteEntiy.getUsuarioId());

        suporteRepository.save(suporteEntiy);
    }
}
