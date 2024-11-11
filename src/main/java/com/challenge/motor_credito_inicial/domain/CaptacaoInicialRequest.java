package com.challenge.motor_credito_inicial.domain;

import lombok.Data;

@Data
public class CaptacaoInicialRequest {
    private String nome;
    private String cpf;
    private String email;

}
