package cl.duoc.rabbitmq_tutorial.service;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service 
public class NotificacionConsumer {

    @RabbitListener(queues = "notificaciones_queue")
    public void recibir(String mensaje){
        System.out.println("NOTIFICACION <---- " + mensaje);
    }

}
