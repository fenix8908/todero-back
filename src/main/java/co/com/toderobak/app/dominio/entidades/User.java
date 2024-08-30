package co.com.toderobak.app.dominio.entidades;


import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class User {

    private Long id;
    private String userName;
    private String password;

    private Set<Rol> roles = new HashSet<>();
}
