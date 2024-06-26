package co.com.security.seguridad_jwt.jwt;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Date;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        //Se captura el jwt en cda peticionz
        final String requestTokenHeader = request.getHeader("Authorization");
        String username = null;
        String jwtToken = null;

        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            jwtToken = requestTokenHeader.substring(7);
            try {
                username = jwtTokenUtil.getUsernameFromToken(jwtToken);
            } catch (IllegalArgumentException e) {
                generarRespuesta(response,"No se pudo obtener el token JWT");
                return;
            } catch (ExpiredJwtException e) {
                generarRespuesta(response,"La sesión actual éxpiro intente iniciar sesión nuevamente");
                return;
            }
        } else {
            logger.warn("El token JWT no comienza con Bearer");
        }
        if (jwtToken != null && username != null) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
            if (debeRefrescarToken(jwtToken)) {
                String refreshToken = request.getHeader("RefreshToken");
                if (refreshToken != null && jwtTokenUtil.validateToken(refreshToken, userDetails)) {
                    String newAccessToken = jwtTokenUtil.generateToken(userDetails,"access");
                    String newRefreshToken = jwtTokenUtil.resfrescarToken(refreshToken);
                    jwtToken = newAccessToken;  // Actualiza el token que se usa para la autenticación
                    // Devolver los tokens en cabeceras para ser tomadas por el front
                    response.addHeader("newAccessToken",jwtToken);
                    response.addHeader("newRefreshToken",newRefreshToken);
                } else {
                    generarRespuesta(response, "El refresh token no es válido o ha expirado");
                    return;
                }
            }
            validarAutenticacion(request, username, jwtToken,userDetails);
        }

        filterChain.doFilter(request, response);
    }

    private void validarAutenticacion(HttpServletRequest request, String username, String jwtToken,UserDetails userDetails) {
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
    }

    private void generarRespuesta(HttpServletResponse response,String mensaje) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        response.getWriter().write("{\"error\": \"" + mensaje + "\"}");
        logger.warn(mensaje);
    }


    private boolean debeRefrescarToken(String token) {
        // Refrescar si faltan menos de 5 minutos para expirar
        Date expirationDate = jwtTokenUtil.getExpirationDateFromToken(token);
        return expirationDate.before(new Date(System.currentTimeMillis() + 5 * 60 * 1000));
    }

}
