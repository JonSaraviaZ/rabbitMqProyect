package cl.duoc.rabbitmq_tutorial.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.rabbitmq_tutorial.service.EventoProducer;


@RestController 
@RequestMapping ("/Eventos")
public class EventoController {
    private final EventoProducer eventoProducer;

    public EventoController(EventoProducer eventoProducer){
        this.eventoProducer = eventoProducer;
    }
    @PostMapping
    public String publicar(@RequestParam String mensaje) {
        eventoProducer.publicar(mensaje);
        return "Evento publicado";
    }
    
}
