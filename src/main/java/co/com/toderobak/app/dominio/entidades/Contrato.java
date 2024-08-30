package co.com.toderobak.app.dominio.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Contrato implements Serializable {

    private Long id;
    private Presupuesto presupuesto;
    private Cliente cliente;
    private Experto experto;
    private Date fechaContrato;
    private String estadoContrato;
}
