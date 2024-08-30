package co.com.toderobak.app.rabbitmq.publishers;

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