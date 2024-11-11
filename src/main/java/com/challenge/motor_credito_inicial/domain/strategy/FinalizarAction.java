package com.challenge.motor_credito_inicial.domain.strategy;

import com.challenge.motor_credito_inicial.domain.CaptacaoInicialRequest;
import com.challenge.motor_credito_inicial.domain.StatusEnum;
import com.challenge.motor_credito_inicial.domain.captacao.CaptacaoRequest;
import com.challenge.motor_credito_inicial.domain.captacao.ClienteRequest;
import com.challenge.motor_credito_inicial.publisher.CaptacaoProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class FinalizarAction implements ActionStrategy {
    private final CaptacaoProducer captacaoProducer;
    private final ModelMapper mapper;

    @Override
    public void execute(CaptacaoInicialRequest request, StatusEnum statusEnum) {
        log.info("Cliente com dados inadimplentes, enviar para o topico de persistencia e notificacao");
        ClienteRequest clienteRequest = mapper.map(request, ClienteRequest.class);

        CaptacaoRequest captacaoRequest = CaptacaoRequest
                .builder()
                .statusEnum(statusEnum)
                .clienteRequest(clienteRequest)
                .propostaRequest(null)
                .build();

        captacaoProducer
                .sendMessage(captacaoRequest);
    }
}
