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
public class Presupuesto  implements Serializable {

    private Long id;
    private Cliente cliente;
    private Experto experto;
    private Servicio servicio;
    private String descripcionDetallada;
    private Double precioEstimado;
    private Date fechaCreacion;
    private List<Contrato> contratos;
}
