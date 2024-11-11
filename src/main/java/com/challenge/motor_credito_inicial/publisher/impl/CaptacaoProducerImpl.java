package com.challenge.motor_credito_inicial.publisher.impl;

import com.challenge.motor_credito_inicial.config.RabbitMQConfig;
import com.challenge.motor_credito_inicial.domain.captacao.CaptacaoRequest;
import com.challenge.motor_credito_inicial.publisher.CaptacaoProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CaptacaoProducerImpl implements CaptacaoProducer {

    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(CaptacaoRequest message) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.APP_EXCHANGE, RabbitMQConfig.SALVAR_CAPTACAO_ROUTING_KEY, message);
    }
}
