package com.challenge.motor_credito_inicial.service;

import com.challenge.motor_credito_inicial.domain.CaptacaoInicialRequest;
import com.challenge.motor_credito_inicial.domain.StatusEnum;
import com.challenge.motor_credito_inicial.domain.strategy.ActionStrategyContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.challenge.motor_credito_inicial.factory.StatusFactory.getRandomStatus;


@Service
@Slf4j
@RequiredArgsConstructor
public class MotorCreditoInicialService {
    private final ActionStrategyContext actionStrategyContext;

    public void process(CaptacaoInicialRequest message) {
        StatusEnum randomStatus = getRandomStatus();
        actionStrategyContext.executeStrategy(randomStatus, message);
    }
}
