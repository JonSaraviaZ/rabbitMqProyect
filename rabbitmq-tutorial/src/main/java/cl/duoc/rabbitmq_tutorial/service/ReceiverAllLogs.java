package cl.duoc.rabbitmq_tutorial.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import cl.duoc.rabbitmq_tutorial.config.rabbitMQConfig;

@Service 
public class ReceiverAllLogs {

    @RabbitListener (queues = rabbitMQConfig.ALL_LOGS_QUEUE)
    public void recibir(String mensaje) {
        System.out.println(" ALL LOGS -->'" + mensaje + "'");
    }

}
