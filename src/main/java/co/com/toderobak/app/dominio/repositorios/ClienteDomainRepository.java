package co.com.toderobak.app.dominio.repositorios;


import co.com.toderobak.app.dominio.entidades.Cliente;

import java.util.List;

public interface ClienteDomainRepository {
    List<Cliente> obtenerClientes();
    Cliente buscarClientePorId(Long id);

}
