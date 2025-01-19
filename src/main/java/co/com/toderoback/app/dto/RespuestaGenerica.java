package co.com.toderoback.app.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@Builder
public class RespuestaGenerica<T> {

    private boolean success; // Indica si la operación fue exitosa
    private String mensaje; // Mensaje descriptivo
    private T data; // Datos genéricos de la respuesta
    private String codigoError; // Código de error opcional

}
