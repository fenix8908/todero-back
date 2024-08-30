package co.com.toderoback.app.services;

import co.com.toderoback.app.repository.ClienteRepository;
import co.com.toderoback.app.dto.ClienteRequest;
import co.com.toderoback.app.entity.Cliente;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> obtenerClientes() {
        return clienteRepository.findAll();
    }

    public Cliente buscarClientePorId(Long id) {
        Optional<Cliente> clienteObtenido = clienteRepository.findById(id);
        if (clienteObtenido.isPresent()) {
            return clienteObtenido.get();
        } else {
            throw new NoSuchElementException("El cliente indicado no existe");
        }
    }

    @Transactional
    public Cliente crearcliente(ClienteRequest clienteRequest) {
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

    @Transactional
    public Cliente editarCliente(ClienteRequest clienteRequest, Long id) {
        Optional<Cliente> clienteObtenido = clienteRepository.findById(id);
        if (clienteObtenido.isPresent()) {
            Cliente cliente = Cliente.builder().build();
            cliente.setId(id);
            cliente.setNombre(clienteRequest.getNombre());
            cliente.setApellido(clienteRequest.getApellido());
            cliente.setTelefono(clienteRequest.getTelefono());
            cliente.setEmail(clienteRequest.getEmail());
            cliente.setDireccion(clienteRequest.getDireccion());
            cliente.setFechaRegistro(clienteRequest.getFechaRegistro());
            return clienteRepository.save(cliente);
        } else {
            throw new NoSuchElementException("El cliente no se encuentra registrado");
        }
    }


}
