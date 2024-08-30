package co.com.toderoback.app.entity;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Verificacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "experto_id", nullable = true)
    private Experto experto;

    @ManyToOne
    @JoinColumn(name = "proveedor_id", nullable = true)
    private Proveedor proveedor;

    private String estadoVerificacion;
    private Date fechaVerificacion;
}
