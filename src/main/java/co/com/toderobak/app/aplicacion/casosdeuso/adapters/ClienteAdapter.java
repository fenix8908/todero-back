package co.com.toderobak.app.aplicacion.casosdeuso.adapters;

import co.com.toderobak.app.aplicacion.casosdeuso.ports.ClientePort;
import co.com.toderobak.app.dominio.entidades.Cliente;
import co.com.toderobak.app.dominio.repositorios.ClienteDomainRepository;

import java.util.List;

public class ClienteAdapter implements ClientePort {
    private final ClienteDomainRepository clienteDomainRepository;

    public ClienteAdapter(ClienteDomainRepository clienteDomainRepository) {
        this.clienteDomainRepository = clienteDomainRepository;
    }

    @Override
    public List<Cliente> obtenerClientes() {
        return clienteDomainRepository.obtenerClientes();
    }
}
