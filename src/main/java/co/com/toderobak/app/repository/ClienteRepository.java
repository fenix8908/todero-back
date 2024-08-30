package co.com.toderobak.app.repository;

import co.com.toderobak.app.infraestructura.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
}
