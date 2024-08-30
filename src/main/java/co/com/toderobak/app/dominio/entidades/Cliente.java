package co.com.toderobak.app.dominio.entidades;

import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class Cliente implements Serializable {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String direccion;
    private Date fechaRegistro;
    private List<Presupuesto> presupuestos;
    private List<Contrato> contratos;

}
