package bob.spring.rabbitmqcommon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@PropertySource("classpath:config.properties")
@Component
public class RabbitmqConfig {
    @Autowired
    private Environment env;

    public String getRabbitmqServerUrl() {
        return env.getProperty("RABBITMQ_SERVER_URL");
    }

    public int getRabbitmqServerPort() {
        return Integer.parseInt(env.getProperty("RABBITMQ_SERVER_PORT"));
    }

    public String getDemoQueueName() {
        return env.getProperty("DEMO_QUEUE_NAME");
    }

    public String getDemoExchangeName() {
        return env.getProperty("DEMO_EXCHANGE_NAME");
    }

    public String getDemoRoutingKey() {
        return env.getProperty("DEMO_ROUTING_KEY");
    }

    public String getRabbitmqServerName() {
        return env.getProperty("RABBITMQ_SERVER_NAME");
    }

    public String getRabbitmqServerPassWORD() {
        return env.getProperty("RABBITMQ_SERVER_PASSWORD");
    }


}
