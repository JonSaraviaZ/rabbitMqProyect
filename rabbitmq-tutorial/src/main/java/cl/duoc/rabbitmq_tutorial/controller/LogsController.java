package cl.duoc.rabbitmq_tutorial.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.rabbitmq_tutorial.service.Sender;

@RestController 
@RequestMapping("/logs")
public class LogsController {
    private final Sender sender;

    public LogsController(Sender sender){
        this.sender = sender;
    }

    @PostMapping
    public String enviar(@RequestParam String nivel, @RequestParam String texto){
        sender.enviar(nivel.toUpperCase(), texto);
        return "Mensaje Enviado a RabbitMQ";
    }
}
