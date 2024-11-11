package com.challenge.motor_credito_inicial.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String CAPTACAO_INICIAL_CONCLUIDA = "captacao_inicial_concluida";
    public static final String APP_EXCHANGE = "appExchange";

    public static final String MOTOR_CREDITO_P1_CONCLUIDO_QUEUE = "motor_credito_p1_concluido";
    public static final String MOTOR_CREDITO_P1_CONCUIDO_ROUTING_KEY = "motor.credito.concluido.key";

    public static final String SALVAR_CAPTACAO = "salvar_captacao";
    public static final String SALVAR_CAPTACAO_ROUTING_KEY = "salvar_captacao.routing.key";

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, Jackson2JsonMessageConverter messageConverter) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }

    @Bean
    public Queue captacaoInicialQueue() {
        return new Queue(CAPTACAO_INICIAL_CONCLUIDA, true);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(APP_EXCHANGE);
    }

    @Bean
    public Queue motorCreditoP1ConcluidoQueue() {
        return new Queue(MOTOR_CREDITO_P1_CONCLUIDO_QUEUE, true);
    }

    @Bean
    public Binding motorCreditoP1ConcluidoBinding(Queue motorCreditoP1ConcluidoQueue, TopicExchange exchange) {
        return BindingBuilder.bind(motorCreditoP1ConcluidoQueue).to(exchange).with(MOTOR_CREDITO_P1_CONCUIDO_ROUTING_KEY);
    }

    @Bean
    public Queue salvarCaptacaoQueue() {
        return new Queue(SALVAR_CAPTACAO, true);
    }

    @Bean
    public Binding salvarCaptacaoBinding(Queue salvarCaptacaoQueue, TopicExchange exchange) {
        return BindingBuilder.bind(salvarCaptacaoQueue).to(exchange).with(SALVAR_CAPTACAO_ROUTING_KEY);
    }
}
