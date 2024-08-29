package co.com.security.seguridad_jwt.rabbitmq.consumers;

import co.com.security.seguridad_jwt.config.RabbitMQConfig;
import co.com.security.seguridad_jwt.dto.JwtResponse;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/*@Component
public class ApiSeguridadConsumer {


    @RabbitListener(queues = RabbitMQConfig.QUEUE_JWT_RESPONSE)
    public JwtResponse createAuthenticationToken(@Payload JwtResponse jwtResponse) {
        return jwtResponse;
    }
}
*/