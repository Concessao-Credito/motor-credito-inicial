package com.challenge.motor_credito_inicial.publisher;

import com.challenge.motor_credito_inicial.domain.CaptacaoInicialRequest;

public interface CaptacaoCompletaProducer {
    void sendMessage(CaptacaoInicialRequest message);
}
