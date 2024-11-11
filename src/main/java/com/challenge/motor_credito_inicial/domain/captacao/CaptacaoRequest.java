package com.challenge.motor_credito_inicial.domain.captacao;

import com.challenge.motor_credito_inicial.domain.StatusEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CaptacaoRequest {
    private ClienteRequest clienteRequest;
    private PropostaRequest propostaRequest;
    private StatusEnum statusEnum;
}
