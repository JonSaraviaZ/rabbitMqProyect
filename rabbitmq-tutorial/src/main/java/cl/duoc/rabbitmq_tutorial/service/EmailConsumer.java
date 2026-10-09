package cl.duoc.rabbitmq_tutorial.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


public class EmailConsumer {
    @RabbitListener(queues = rabbitMQConfig.EMAIL_QUEUE)
    public void recibir(String mensaje) {
        System.out.println("EMAIL -->'" + mensaje + "'");
    }

    

}
