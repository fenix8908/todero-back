package co.com.security.seguridad_jwt.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME = "cola1";
    public static final String EXCHANGE_NAME = "exchange1";
    public static final String ROUTING_KEY = "routingKey1";

    @Bean
    public Queue queue (){
        return new Queue(QUEUE_NAME,true);
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange){

        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }
}
