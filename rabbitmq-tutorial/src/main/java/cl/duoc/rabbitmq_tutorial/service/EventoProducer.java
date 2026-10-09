package cl.duoc.rabbitmq_tutorial.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import cl.duoc.rabbitmq_tutorial.config.rabbitMQConfig;

@Service 
public class EventoProducer {
    private final RabbitTemplate rabbitTemplate;

    public EventoProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publicar (String mensaje){
        rabbitTemplate.convertAndSend(rabbitMQConfig.EVENTOS_EXCHANGE,"",mensaje);
        System.out.println("PUBLICADO ---> "+ mensaje);
    }
    
}
