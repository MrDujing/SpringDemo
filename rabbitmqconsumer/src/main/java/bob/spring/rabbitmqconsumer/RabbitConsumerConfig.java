package bob.spring.rabbitmqconsumer;

import bob.spring.rabbitmqcommon.RabbitmqConfig;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class RabbitConsumerConfig {
    @Resource
    private RabbitmqConfig rabbitmqConfig;

    @Bean
    public Queue getDemoQueue() {
        return new Queue(rabbitmqConfig.getDemoQueueName(), false, false, false);
    }

    @Bean
    ConnectionFactory connectionFactory(@Value("${spring.rabbitmq.port}") int port,
                                        @Value("${spring.rabbitmq.host}") String host,
                                        @Value("${spring.rabbitmq.username}") String userName,
                                        @Value("${spring.rabbitmq.password}") String password,
                                        @Value("${spring.rabbitmq.virtual-host}") String vhost) {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(host);
        connectionFactory.setVirtualHost(vhost);
        connectionFactory.setPort(port);
        connectionFactory.setUsername(userName);
        connectionFactory.setPassword(password);
        return connectionFactory;
    }

    @Bean
    public SimpleMessageListenerContainer msgContainer(DemoListenerService listenerProcess, ConnectionFactory connectionFactory) throws AmqpException {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setQueueNames(rabbitmqConfig.getDemoQueueName());
        container.setExposeListenerChannel(true);
        container.setMessageListener(listenerProcess);//监听处理类
        return container;
    }
}



