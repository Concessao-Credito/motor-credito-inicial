package com.challenge.motor_credito_inicial.publisher.impl;

import com.challenge.motor_credito_inicial.config.RabbitMQConfig;
import com.challenge.motor_credito_inicial.domain.CaptacaoInicialRequest;
import com.challenge.motor_credito_inicial.publisher.CaptacaoCompletaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CaptacaoCompletaProducerImpl implements CaptacaoCompletaProducer {
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(CaptacaoInicialRequest message) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.APP_EXCHANGE, RabbitMQConfig.MOTOR_CREDITO_P1_CONCUIDO_ROUTING_KEY, message);
    }
}
