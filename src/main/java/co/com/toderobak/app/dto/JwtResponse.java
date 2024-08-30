package co.com.toderobak.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class JwtResponse  implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private String tokenResponse;
    private String refreshToken;
}
