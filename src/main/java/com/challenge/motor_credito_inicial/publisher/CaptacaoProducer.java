package com.challenge.motor_credito_inicial.publisher;

import com.challenge.motor_credito_inicial.domain.captacao.CaptacaoRequest;

public interface CaptacaoProducer {
    void sendMessage(CaptacaoRequest message);
}
