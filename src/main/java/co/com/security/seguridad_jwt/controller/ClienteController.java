package co.com.security.seguridad_jwt.controller;

import co.com.security.seguridad_jwt.entity.Cliente;
import co.com.security.seguridad_jwt.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listado")
    public ResponseEntity<List<Cliente>> consultarClientes(){
        List<Cliente> clientes =  clienteService.obtenerClientes();
        return ResponseEntity.ok(clientes);
    }
}
