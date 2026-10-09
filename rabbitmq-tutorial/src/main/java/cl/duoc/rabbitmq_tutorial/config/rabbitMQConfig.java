package cl.duoc.rabbitmq_tutorial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;

@Configuration 
public class rabbitMQConfig { //Acá indicamos que el spring necesita una cola de mensajes para poder enviar y recibir mensajes, por lo que creamos una clase de configuración para crear la cola de mensajes
    public static final String ALL_LOGS_QUEUE= "all_logs_queue"; //Acá indicamos el nombre de la cola de mensajes que vamos a crear

    public static final String ERRORS_QUEUE = "errors_only_queue"; //Acá indicamos el nombre de la cola de mensajes de error que vamos a crear

    public static final String EXCHANGE = "logs_direct_exchange"; //Acá indicamos el nombre del exchange que vamos a crear

    //Logs

    @Bean
    public Queue allLogsQueue() {
        return new Queue(ALL_LOGS_QUEUE, true); // si es false, la cola no es durable, si es true, la cola es durable y sobrevive a reinicios del broker 
    }

    @Bean
    public Queue errorOnlyQueue() { //Acá indicamos que vamos a crear una cola de mensajes de error, que es una cola de mensajes que solo recibirá mensajes de error, y que es durable, lo que significa que sobrevivirá a reinicios del broker
        return new Queue(ERRORS_QUEUE, true); 
    }

    @Bean 
    public DirectExchange logsExchange() {
        return new DirectExchange(EXCHANGE); //Acá indicamos que vamos a crear un exchange de tipo direct, que es un tipo de exchange que permite enviar mensajes a colas específicas según la clave de enrutamiento (routing key) que se utilice al enviar el mensaje.
    }

    //Binding: Es una relación entre una cola y un exchange

    @Bean
    public Binding bindingInfo(){ //Acá indicamos que vamos a crear un binding, que es una relación entre una cola y un exchange, y que vamos a utilizar la clave de enrutamiento "info" para enviar mensajes a la cola de mensajes de todos los logs.
        return BindingBuilder
        .bind(allLogsQueue()) //indicamos desde dónde vienen los mensajes
        .to(logsExchange()) // hacia donde van los mensajes
        .with("INFO"); // qué tipo de mensaje se va a enviar, en este caso, mensajes de información
    }

    @Bean
    public Binding bindingWarning(){ //Acá indicamos que vamos a crear un binding, que es una relación entre una cola y un exchange, y que vamos a utilizar la clave de enrutamiento "info" para enviar mensajes a la cola de mensajes de todos los logs.
        return BindingBuilder
        .bind(allLogsQueue()) //indicamos desde dónde vienen los mensajes
        .to(logsExchange()) // hacia donde van los mensajes
        .with("WARNING"); // qué tipo de mensaje se va a enviar, en este caso, mensajes de información
    }

    @Bean
    public Binding bindingError(){ //Acá indicamos que vamos a crear un binding, que es una relación entre una cola y un exchange, y que vamos a utilizar la clave de enrutamiento "info" para enviar mensajes a la cola de mensajes de todos los logs.
        return BindingBuilder
        .bind(allLogsQueue()) //indicamos desde dónde vienen los mensajes
        .to(logsExchange()) // hacia donde van los mensajes
        .with("ERROR"); // qué tipo de mensaje se va a enviar, en este caso, mensajes de información
    }

    @Bean
    public Binding bindingErrorOnly(){ //Acá indicamos que vamos a crear un binding, que es una relación entre una cola y un exchange, y que vamos a utilizar la clave de enrutamiento "info" para enviar mensajes a la cola de mensajes de todos los logs.
        return BindingBuilder
        .bind(errorOnlyQueue()) //indicamos desde dónde vienen los mensajes
        .to(logsExchange()) // hacia donde van los mensajes
        .with("ERROR"); // qué tipo de mensaje se va a enviar, en este caso, mensajes de información
    }

    //código paran fanout

    public static final String EVENTOS_EXCHANGE ="eventos_fanout_exchange"; //Acá indicamos el nombre del exchange que vamos a crear

    public static final String EMAIL_QUEUE = "email_queue";//Acá indicamos el nombre de la cola de mensajes que vamos a crear
    public static final String AUDITORIA_QUEUE = "auditoria_queue";
    public static final String NOTIFICACIONES_QUEUE = "notificaciones_queue";

    @Bean 
    public FanoutExchange eventosExchange() {
        return new FanoutExchange(EVENTOS_EXCHANGE); //Acá indicamos que vamos a crear un exchange de tipo direct, que es un tipo de exchange que permite enviar mensajes a colas específicas según la clave de enrutamiento (routing key) que se utilice al enviar el mensaje.
    }

    @Bean
    public Queue emailQueue() {
        return new Queue(EMAIL_QUEUE, true); // si es false, la cola no es durable, si es true, la cola es durable y sobrevive a reinicios del broker
    }

    @Bean
    public Queue auditoriaQueue() {
        return new Queue(AUDITORIA_QUEUE, true); // si es false, la cola no es durable, si es true, la cola es durable y sobrevive a reinicios del broker
    }

    @Bean
    public Queue notificacionesQueue() {
        return new Queue(NOTIFICACIONES_QUEUE, true); // si es false, la cola no es durable, si es true, la cola es durable y sobrevive a reinicios del broker
    }

    @Bean
    public Binding emailBinding() {
        return BindingBuilder
                .bind(emailQueue())
                .to(eventosExchange());
    }

    @Bean
    public Binding auditoriaBinding() {
        return BindingBuilder
                .bind(auditoriaQueue())
                .to(eventosExchange());
    }

    @Bean
    public Binding notificacionesBinding() {
        return BindingBuilder
                .bind(notificacionesQueue())
                .to(eventosExchange());
    }
    
    
}
