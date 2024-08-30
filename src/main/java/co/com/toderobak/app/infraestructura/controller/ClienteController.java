package co.com.toderobak.app.infraestructura.controller;

import co.com.toderobak.app.dto.ClienteRequest;
import co.com.toderobak.app.infraestructura.entity.ClienteEntity;
import co.com.toderobak.app.infraestructura.services.ClienteService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/clientes")
public class ClienteController {

    private Logger log = LoggerFactory.getLogger(ClienteController.class);
    @Autowired
    private ClienteService clienteService;


    @Secured({"ROLE_ADMIN"})
    @GetMapping("/listado")
    public ResponseEntity<List<ClienteEntity>> consultarClientes() {
        try {
            List<ClienteEntity> clienteEntities = clienteService.obtenerClientes();
            return ResponseEntity.ok(clienteEntities);
        } catch (Exception ex) {
            log.error(ex.toString());
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Secured({"ROLE_ADMIN","ROLE_USER"})
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> obtenerClientePorId(@PathVariable("id") long id) {
        try {
            ClienteEntity clienteEntity = clienteService.buscarClientePorId(id);
            return ResponseEntity.ok(clienteEntity);
        } catch (Exception ex) {
            log.error(ex.toString());
            if(ex.getMessage().equals("El cliente indicado no existe")){
                return ResponseEntity.status(404).body(ex.getMessage());
            }
            throw new RuntimeException(ex.getMessage());
        }
    }



    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PostMapping(value = "/crear", produces = "application/json")
    public ResponseEntity<?> clearCliente(@Valid @RequestBody ClienteRequest clienteRequest) {
        try {
            ClienteEntity clienteEntity = clienteService.crearcliente(clienteRequest);
            return ResponseEntity.ok(clienteEntity);
        } catch (Exception ex) {
            log.error(ex.toString());
            return ResponseEntity.badRequest().body("No fue posible crear el cliente");
        }
    }


    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PutMapping(value = "/editar/{id}", produces = "application/json")
    public ResponseEntity<?> editarCliente(@Valid @RequestBody ClienteRequest clienteRequest, @PathVariable("id") long id) {
        try {
            ClienteEntity clienteEntity = clienteService.editarCliente(clienteRequest, id);
            return ResponseEntity.ok(clienteEntity);
        } catch (Exception ex) {
            log.error(ex.toString());
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
