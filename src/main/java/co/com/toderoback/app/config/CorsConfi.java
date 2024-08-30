package co.com.toderoback.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfi implements WebMvcConfigurer{

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // para todos los end points
                .allowedOrigins("http://localhost:4200")  //para los request de este origen
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // para estos metodos
                .allowedHeaders("Authorization", "Content-Type", "Accept", "Application-JSON","RefreshToken")  //Permitir todos los encabezados (cuidado en producción)
                .exposedHeaders("newAccessToken", "newRefreshToken")  // Exponer estos headers
                .allowCredentials(false);  //Establezca en verdadero si permite credenciales (cookies, etc.)
    }


}
