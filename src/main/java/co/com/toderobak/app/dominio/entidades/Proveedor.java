package co.com.toderobak.app.dominio.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Proveedor  implements Serializable {

    private Long id;
    private String nombre;
    private String email;
    private String telefono;
    private String direccion;
    private boolean verificado;
    private Date fechaRegistro;
    private String numeroIdentificacion;
    private String registroLegal;
    private String certificaciones;
    private String estadoVerificacion;
    private Date fechaVerificacion;
    private String comentariosVerificacion;
    private String informacionFinanciera;
    private String contactoPrincipal;
    private String serviciosOfrecidos;
    private List<Permisos.Verificacion> verificaciones;
}
