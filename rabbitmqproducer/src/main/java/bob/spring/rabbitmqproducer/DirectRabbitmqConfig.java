package bob.spring.rabbitmqproducer;

import bob.spring.common.RabbitmqConfig;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectRabbitmqConfig {
    @Autowired
    private RabbitmqConfig rabbitmqConfig;

    @Bean
    public Queue getDemoDirectQueue() {
        return new Queue(rabbitmqConfig.getDemoQueueName(), true, false, false);
    }

    @Bean
    public DirectExchange getDemoExchange() {
        return new DirectExchange(rabbitmqConfig.getDemoExchangeName(),true, false);
    }

    @Bean
    public Binding bindingDirect() {
        return BindingBuilder
                .bind(getDemoDirectQueue())
                .to(getDemoExchange())
                .with(rabbitmqConfig.getDemoRoutingKey());
    }
}
