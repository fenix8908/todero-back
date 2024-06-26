package co.com.security.seguridad_jwt.services;

import co.com.security.seguridad_jwt.entity.Cliente;
import co.com.security.seguridad_jwt.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> obtenerClientes() {
        return clienteRepository.findAll();
    }

}
