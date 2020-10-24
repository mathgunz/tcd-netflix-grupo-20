package com.netflix.suporte.core.interfaces.listeners;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.suporte.core.application.domains.Suporte;
import com.netflix.suporte.core.application.usecases.SuporteUseCase;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class SuporteListener {

    private final SuporteUseCase suporteUseCase;

    public SuporteListener(SuporteUseCase suporteUseCase) {
        this.suporteUseCase = suporteUseCase;
    }

    @KafkaListener(topics = "${order.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void receberChamado(@Payload String result) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        Suporte suporte = objectMapper.readValue(result, Suporte.class);

        suporteUseCase.abrirChamado(suporte);

    }
}