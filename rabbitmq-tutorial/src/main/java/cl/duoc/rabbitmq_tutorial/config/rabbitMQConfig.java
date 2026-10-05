package cl.duoc.rabbitmq_tutorial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

@Configuration 
public class rabbitMQConfig { //Acá indicamos que el spring necesita una cola de mensajes para poder enviar y recibir mensajes, por lo que creamos una clase de configuración para crear la cola de mensajes
    public static final String QUEUE_NAME = "hello";

    @Bean
    public Queue helloQueue() {
        return new Queue(QUEUE_NAME, false);
    }

}
