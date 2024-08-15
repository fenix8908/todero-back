package co.com.security.seguridad_jwt.controller;

import co.com.security.seguridad_jwt.dto.User;
import co.com.security.seguridad_jwt.rabbitmq.publishers.ApiSeguridadPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rabbit")
public class RabbitController {

    @Autowired
    private ApiSeguridadPublisher apiSeguridadPublisher;

    @GetMapping("/publicar/{mensaje}")
    public ResponseEntity<?> enviarMensajeCola(@PathVariable("mensaje") String mensaje){
        try {
            apiSeguridadPublisher.enviarMensajeApiSeguridad(mensaje);
            return ResponseEntity.ok("Mensaje publicado con exito");
        }catch (Exception ex){
            return ResponseEntity.status(500).body(ex.getMessage());
        }
    }

    @PostMapping("/publicar-objeto")
    public ResponseEntity<?> enviarObjetoCola(@RequestBody User user){
        try {
            apiSeguridadPublisher.enviarMensajeApiSeguridad(user);
            return ResponseEntity.ok("Mensaje publicado con exito");
        }catch (Exception ex){
            return ResponseEntity.status(500).body(ex.getMessage());
        }
    }
}
