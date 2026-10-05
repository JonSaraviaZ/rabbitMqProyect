package cl.duoc.rabbitmq_tutorial.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service 
public class Receiver {

    @RabbitListener (queues = rabbitMQConfig.QUEUE_NAME)
    public void recibir(String mensaje) {
        System.out.println(" Recibido -->'" + mensaje + "'");
    }

}
