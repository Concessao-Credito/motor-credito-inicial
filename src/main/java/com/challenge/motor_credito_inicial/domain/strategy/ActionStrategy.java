package com.challenge.motor_credito_inicial.domain.strategy;

import com.challenge.motor_credito_inicial.domain.CaptacaoInicialRequest;
import com.challenge.motor_credito_inicial.domain.StatusEnum;

public interface ActionStrategy {

    void execute(CaptacaoInicialRequest request, StatusEnum statusEnum);

}
