package com.netflix.suporte.api.application.services.domains;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.suporte.api.application.usecases.PublicarChamadoUseCase;
import com.netflix.suporte.api.interfaces.controllers.dtos.SuporteDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PublicarChamadoService implements PublicarChamadoUseCase {

    @Value("${order.topic}")
    private String orderTopic;

    private final KafkaTemplate kafkaTemplate;

    public PublicarChamadoService(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publicar(SuporteDto suporte) {

        try {

            final String mensageKey = UUID.randomUUID().toString();

            ObjectMapper objectMapper = new ObjectMapper();
            String result = objectMapper.writeValueAsString(suporte);
            kafkaTemplate.send(orderTopic, mensageKey, result);

        } catch (Exception e) {
            throw new RuntimeException("");
        }
    }
}
