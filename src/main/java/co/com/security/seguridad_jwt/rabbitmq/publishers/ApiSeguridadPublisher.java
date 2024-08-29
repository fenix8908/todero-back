package co.com.security.seguridad_jwt.rabbitmq.publishers;

import co.com.security.seguridad_jwt.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*@Component
@EnableRabbit
public class ApiSeguridadPublisher {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public ApiSeguridadPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
    }
    public void enviarMensajeApiSeguridad(Object mensaje) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY, mensaje);
    }

}
*/