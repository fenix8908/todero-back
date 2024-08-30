package co.com.toderobak.app.infraestructura.services;

import co.com.toderobak.app.dominio.entidades.Cliente;
import co.com.toderobak.app.dominio.repositorios.ClienteDomainRepository;
import co.com.toderobak.app.infraestructura.entity.ClienteEntity;
import co.com.toderobak.app.infraestructura.mappers.ClienteMapper;
import co.com.toderobak.app.infraestructura.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteImpl implements ClienteDomainRepository {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    @Override
    public List<Cliente> obtenerClientes() {
        List<ClienteEntity> clientes = clienteRepository.findAll();
        return clienteMapper.clienteEntityListAclienteDomainList(clientes);
    }

    @Override
    public Cliente buscarClientePorId(Long id) {
        return null;
    }
}
