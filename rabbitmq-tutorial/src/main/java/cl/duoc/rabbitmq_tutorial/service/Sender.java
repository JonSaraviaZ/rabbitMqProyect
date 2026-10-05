package cl.duoc.rabbitmq_tutorial.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import cl.duoc.rabbitmq_tutorial.config.rabbitMQConfig;

@Service 
public class Sender {

    private final RabbitTemplate rabbitTemplate;

    private final rabbitTemplate;

    public Sender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;

    }

    public void enviar(String mensaje){
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, mensaje);
        System.out.println(" Enviado -->'" + mensaje + "'");
    }

}
