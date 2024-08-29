package co.com.security.seguridad_jwt.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;

//@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME = "cola1";
    public static final String QUEUE_JWT_RESPONSE = "colajwt";
    public static final String EXCHANGE_NAME = "exchange1";
    public static final String ROUTING_KEY = "routingKey1";
    public static final String ROUTING_KEY_JWT = "routingKeyJwt";

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    public Queue queue (){
        return new Queue(QUEUE_NAME,true);
    }
    @Bean
    public Queue queueJwt (){
        return new Queue(QUEUE_JWT_RESPONSE,true);
    }


    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange){

        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }

    @Bean
    public Binding bindingJtwt(Queue queue, TopicExchange exchange){

        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY_JWT);
    }
}
