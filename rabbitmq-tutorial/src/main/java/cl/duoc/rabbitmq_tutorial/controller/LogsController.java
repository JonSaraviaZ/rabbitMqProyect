package cl.duoc.rabbitmq_tutorial.controller;

import cl.duoc.rabbitmq_tutorial.service.Sender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logs")
public class LogsController {

    private final Sender sender;

    public LogsController(Sender sender) { //Acá indicamos que vamos a crear un binding, que es una relación entre una cola y un exchange, y que vamos a utilizar la clave de enrutamiento "info" para enviar mensajes a la cola de mensajes de todos los logs. 
        this.sender = sender;
    }

    @PostMapping("/path")
    public String enviar(@RequestParam String nivel, @RequestParam String texto) { 
        sender.enviar(nivel.toUpperCase(), texto); 
        return "Mensaje enviado a RabbitMQ";
    }
}