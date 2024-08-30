package co.com.toderoback.app.services;

import co.com.toderoback.app.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesService {

    @Autowired
    private RolesRepository rolesRepository;

    public List<String> obtenerRoles(String usuario){
        return rolesRepository.obtenerRolesPorUsurio(usuario);
    }
}
