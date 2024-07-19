package co.com.security.seguridad_jwt.controller;

import co.com.security.seguridad_jwt.services.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/roles")
public class RolesController {

    @Autowired
    private RolesService rolesService;

    @GetMapping(value = "/por-usuario/{user}", produces = "application/json")
    public ResponseEntity<List<String>> listarRolesPorUsuario(@PathVariable("user") String user){
        List<String> roles = rolesService.obtenerRoles(user);
        return ResponseEntity.ok(roles);
    }


}
