package co.com.toderobak.app.infraestructura.services;

import co.com.toderobak.app.dto.ClienteRequest;
import co.com.toderobak.app.repository.ClienteRepository;
import co.com.toderobak.app.infraestructura.entity.ClienteEntity;
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

    public List<ClienteEntity> obtenerClientes() {
        return clienteRepository.findAll();
    }

    public ClienteEntity buscarClientePorId(Long id) {
        Optional<ClienteEntity> clienteObtenido = clienteRepository.findById(id);
        if (clienteObtenido.isPresent()) {
            return clienteObtenido.get();
        } else {
            throw new NoSuchElementException("El cliente indicado no existe");
        }
    }

    @Transactional
    public ClienteEntity crearcliente(ClienteRequest clienteRequest) {
        ClienteEntity clienteEntity = ClienteEntity.builder().build();
        clienteEntity.setNombre(clienteRequest.getNombre());
        clienteEntity.setApellido(clienteRequest.getApellido());
        clienteEntity.setTelefono(clienteRequest.getTelefono());
        clienteEntity.setEmail(clienteRequest.getEmail());
        clienteEntity.setDireccion(clienteRequest.getDireccion());
        clienteEntity.setFechaRegistro(clienteRequest.getFechaRegistro());
        return clienteRepository.save(clienteEntity);
        //return  cliente;
    }

    @Transactional
    public ClienteEntity editarCliente(ClienteRequest clienteRequest, Long id) {
        Optional<ClienteEntity> clienteObtenido = clienteRepository.findById(id);
        if (clienteObtenido.isPresent()) {
            ClienteEntity clienteEntity = ClienteEntity.builder().build();
            clienteEntity.setId(id);
            clienteEntity.setNombre(clienteRequest.getNombre());
            clienteEntity.setApellido(clienteRequest.getApellido());
            clienteEntity.setTelefono(clienteRequest.getTelefono());
            clienteEntity.setEmail(clienteRequest.getEmail());
            clienteEntity.setDireccion(clienteRequest.getDireccion());
            clienteEntity.setFechaRegistro(clienteRequest.getFechaRegistro());
            return clienteRepository.save(clienteEntity);
        } else {
            throw new NoSuchElementException("El cliente no se encuentra registrado");
        }
    }


}
