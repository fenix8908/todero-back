package co.com.toderoback.app.repository;

import co.com.toderoback.app.entity.RolEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolesRepository extends JpaRepository<RolEntity, Long> {

    @Query(value = """
            SELECT r.nombre as nombre_rol
            FROM usuarios as u
            INNER JOIN roles_usuario as ru
            on u.id = ru.user_id
            INNER JOIN roles r
            ON r.id = ru.rol_id
            WHERE u.user_name = :usuario
            """,nativeQuery = true)
    List<String> obtenerRolesPorUsurio(String usuario);
}
