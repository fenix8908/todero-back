package co.com.security.seguridad_jwt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class JwtResponse {

    public JwtResponse(String tokenResponse, String refreshToken) {
        this.tokenResponse = tokenResponse;
        this.refreshToken = refreshToken;
    }

    private String tokenResponse;
    private String refreshToken;
    private List<String> roles;
}
