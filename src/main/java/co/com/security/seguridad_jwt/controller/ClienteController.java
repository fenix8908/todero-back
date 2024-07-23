package co.com.security.seguridad_jwt.controller;

import co.com.security.seguridad_jwt.dto.ClienteRequest;
import co.com.security.seguridad_jwt.entity.Cliente;
import co.com.security.seguridad_jwt.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;


    @GetMapping("/listado")
    @Secured({"ROLE_ADMIN"})
    public ResponseEntity<List<Cliente>> consultarClientes() {
        try {
            List<Cliente> clientes = clienteService.obtenerClientes();
            return ResponseEntity.ok(clientes);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @PostMapping(value = "/crear",produces = "application/json")
    @Secured({"ROLE_ADMIN","ROLE_USER"})
    public ResponseEntity<?> clearCliente(@Valid @RequestBody ClienteRequest clienteRequest) {
        try {
            Cliente cliente = clienteService.crearcliente(clienteRequest);
            return ResponseEntity.ok(cliente);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
