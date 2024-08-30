package co.com.toderoback.app.entity;

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
public class Presupuesto  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "experto_id")
    private Experto experto;

    @ManyToOne
    @JoinColumn(name = "servicio_id")
    private Servicio servicio;

    private String descripcionDetallada;
    private Double precioEstimado;
    private Date fechaCreacion;

    @OneToMany(mappedBy = "presupuesto")
    private List<Contrato> contratos;
}
