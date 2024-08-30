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
public class Experto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String telefono;
    private String direccion;
    private String especialidad;
    private boolean verificado;
    private Date fechaRegistro;
    private String documentoIdentidad;
    private String tituloAcademico;
    private String certificaciones;
    private String estadoVerificacion;
    private Date fechaVerificacion;
    private String comentariosVerificacion;
    private String experienciaLaboral;
    private String disponibilidadHoraria;
    private Double tarifa;
    private String redesSociales;

    @OneToMany(mappedBy = "experto")
    private List<Presupuesto> presupuestos;

    @OneToMany(mappedBy = "experto")
    private List<Contrato> contratos;
}
