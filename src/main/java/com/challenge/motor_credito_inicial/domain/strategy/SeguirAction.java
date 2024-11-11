package com.challenge.motor_credito_inicial.domain.strategy;

import com.challenge.motor_credito_inicial.domain.CaptacaoInicialRequest;
import com.challenge.motor_credito_inicial.domain.StatusEnum;
import com.challenge.motor_credito_inicial.publisher.CaptacaoCompletaProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class SeguirAction implements ActionStrategy {

    private final CaptacaoCompletaProducer captacaoCompletaProducer;

    @Override
    public void execute(CaptacaoInicialRequest request, StatusEnum statusEnum) {
        log.info("Cliente com dados validos, enviar para o topico de captacao completa");
        captacaoCompletaProducer.sendMessage(request);
    }
}
