package co.com.toderobak.app.dominio.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Servicio implements Serializable {


    private Long id;
    private String descripcion;
    private Double precio;
    private List<Presupuesto> presupuestos;
}
