package co.com.toderoback.app.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteRequest {

    private Long id;
    @NotBlank(message = "El campo  nombre es requerido")
    private String nombre;
    @NotBlank(message = "El campo apellido es requerido")
    private String apellido;
    @Email(message = "El correo no cumple con el formato requerido",regexp = "^[\\w\\.-]+@([\\w\\.-]+\\.[\\w\\.]+)$")
    private String email;
    @NotBlank(message = "El campo telefono es requerido")
    private String telefono;
    private String direccion;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    @Builder.Default
    private Date fechaRegistro = new Date();
}
