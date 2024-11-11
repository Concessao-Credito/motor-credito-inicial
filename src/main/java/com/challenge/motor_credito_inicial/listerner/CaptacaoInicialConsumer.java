package com.challenge.motor_credito_inicial.listerner;

import com.challenge.motor_credito_inicial.config.RabbitMQConfig;
import com.challenge.motor_credito_inicial.domain.CaptacaoInicialRequest;
import com.challenge.motor_credito_inicial.service.MotorCreditoInicialService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CaptacaoInicialConsumer {
    private final MotorCreditoInicialService motorCreditoInicialService;

    @RabbitListener(queues = RabbitMQConfig.CAPTACAO_INICIAL_CONCLUIDA)
    public void receiveMessage(CaptacaoInicialRequest message) {
        log.info("Iniciando o processamento dos dados de captacao inicial");
        motorCreditoInicialService.process(message);
    }
}
