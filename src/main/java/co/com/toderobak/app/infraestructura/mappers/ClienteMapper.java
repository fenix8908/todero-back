package co.com.toderobak.app.infraestructura.mappers;

import co.com.toderobak.app.dominio.entidades.Cliente;
import co.com.toderobak.app.infraestructura.entity.ClienteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    ClienteEntity clienteDomainAclienteEntity(Cliente cliente);

    Cliente clienteEntityAclienteDomain(ClienteEntity clienteEntity);

    List<Cliente> clienteEntityListAclienteDomainList(List<ClienteEntity> clienteEntities);

    List<ClienteEntity> clienteDomainListAclienteEntityList(List<Cliente> clientes);


}
