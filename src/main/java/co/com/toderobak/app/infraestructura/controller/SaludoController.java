package co.com.toderobak.app.infraestructura.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {

    @GetMapping("/saludo")
    public ResponseEntity<String> saludar(){
        return ResponseEntity.ok("Hola gente !!!");
    }
}


