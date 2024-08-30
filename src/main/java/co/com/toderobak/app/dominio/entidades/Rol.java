package co.com.toderobak.app.dominio.entidades;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
public class Rol {

    private Long id;
    private String nombre;
    private Set<User> users = new HashSet<>();
    private Set<Permisos> permisos = new HashSet<>();
}
