package co.com.security.seguridad_jwt.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String direccion;
    private Date fechaRegistro;

    @OneToMany(mappedBy = "cliente")
    private List<Presupuesto> presupuestos;

    @OneToMany(mappedBy = "cliente")
    private List<Contrato> contratos;

}
