package co.com.toderobak.app.dominio.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class Permisos {


    private Long id;
    private String nombre;
    private Set<Rol> roles = new HashSet<>();

    @Getter
    @Setter
    @NoArgsConstructor
    @EqualsAndHashCode
    public static class Verificacion implements Serializable {

        private Long id;
        private Experto experto;
        private Proveedor proveedor;
        private String estadoVerificacion;
        private Date fechaVerificacion;
    }
}
