package co.com.security.seguridad_jwt.controller;

import co.com.security.seguridad_jwt.dto.JwtRequest;
import co.com.security.seguridad_jwt.dto.JwtResponse;
import co.com.security.seguridad_jwt.jwt.JwtTokenUtil;
import co.com.security.seguridad_jwt.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;


    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) {
        try {
            authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
            final UserDetails userDetails = customUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
            final String token = jwtTokenUtil.generateToken(userDetails, "access");
            final String tokenRefresh = jwtTokenUtil.generateToken(userDetails, "refresh");
            List<String> roles = userDetails.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .toList();
            return ResponseEntity.ok(new JwtResponse(token, tokenRefresh, roles));
        } catch (Exception ex) {
            if (ex.getMessage().equals("INVALID_CREDENTIALS")) {
                return ResponseEntity.status(Integer.parseInt("401")).body("Credenciales incorrectas");
            } else {
                return ResponseEntity.badRequest().body("Usuario deshabilitado");
            }
        }


    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
