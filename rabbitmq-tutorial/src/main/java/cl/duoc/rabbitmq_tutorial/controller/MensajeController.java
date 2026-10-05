package cl.duoc.rabbitmq_tutorial.controller;

import cl.duoc.rabbitmq_tutorial.service.Sender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mensajes")
public class MensajeController {

    private final Sender sender;

    public MensajeController(Sender sender) {
        this.sender = sender;
    }

    @PostMapping("/path")
    public String enviar(@RequestBody String texto) {
        sender.enviar(texto);
        return "Mensaje enviado a RabbitMQ";
    }
}