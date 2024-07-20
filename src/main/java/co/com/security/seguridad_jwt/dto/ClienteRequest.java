package co.com.security.seguridad_jwt.dto;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ClienteRequest {

    private Long id;
    @NotBlank(message = "Este campo es requerido")
    private String nombre;
    @NotBlank(message = "Este campo es requerido")
    private String apellido;
    @Email(message = "No cumple con el formato requerido")
    private String email;
    @NotBlank(message = "Este campo es requerido")
    private String telefono;
    private String direccion;
    private Date fechaRegistro;
}
