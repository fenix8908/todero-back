package co.com.toderobak.app.aplicacion.casosdeuso.ports;

import co.com.toderobak.app.dominio.entidades.Cliente;

import java.util.List;

public interface ClientePort {
    List<Cliente> obtenerClientes();
}
