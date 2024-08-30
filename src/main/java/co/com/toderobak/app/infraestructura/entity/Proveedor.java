package co.com.toderobak.app.infraestructura.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Proveedor  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(mappedBy = "proveedor")
    private List<Verificacion> verificaciones;
}
