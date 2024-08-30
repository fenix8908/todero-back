package co.com.toderobak.app.dominio.servicios;

import co.com.toderobak.app.dominio.entidades.Cliente;
import co.com.toderobak.app.dominio.repositorios.ClienteDomainRepository;

import java.util.List;

public class ClienteDomainService {

    private final ClienteDomainRepository clienteDomainRepository;

    public ClienteDomainService(ClienteDomainRepository clienteDomainRepository) {
        this.clienteDomainRepository = clienteDomainRepository;
    }

    List<Cliente> obtenerClientes(){
        return clienteDomainRepository.obtenerClientes();
    }
}
