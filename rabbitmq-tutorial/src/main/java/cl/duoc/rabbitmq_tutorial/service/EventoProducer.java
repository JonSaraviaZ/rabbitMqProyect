package cl.duoc.rabbitmq_tutorial.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventoProducer {

    private final RabbitTemplate rabbitTemplate;

    public EventoProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publicarEvento(String mensaje){
        rabbitTemplate.convertAndSend(RabbitMQConfig.EVENTOS_EXCHANGE, "", mensaje); //Acá indicamos que vamos a enviar un mensaje al exchange de tipo fanout, que es un tipo de exchange que envía mensajes a todas las colas que están vinculadas a él, sin importar la clave de enrutamiento (routing key) que se utilice al enviar el mensaje.
        System.out.println("Evento publicado: " + mensaje);
    }

}
