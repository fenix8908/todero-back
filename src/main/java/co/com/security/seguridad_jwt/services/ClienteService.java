package co.com.security.seguridad_jwt.services;

import co.com.security.seguridad_jwt.dto.ClienteRequest;
import co.com.security.seguridad_jwt.entity.Cliente;
import co.com.security.seguridad_jwt.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> obtenerClientes() {
        return clienteRepository.findAll();
    }

    @Transactional
    public Cliente crearcliente(ClienteRequest clienteRequest){
        Cliente cliente = Cliente.builder().build();
        cliente.setNombre(clienteRequest.getNombre());
        cliente.setApellido(clienteRequest.getApellido());
        cliente.setTelefono(clienteRequest.getTelefono());
        cliente.setEmail(clienteRequest.getEmail());
        cliente.setDireccion(clienteRequest.getDireccion());
        cliente.setFechaRegistro(clienteRequest.getFechaRegistro());
        return clienteRepository.save(cliente);
        //return  cliente;
    }


}
