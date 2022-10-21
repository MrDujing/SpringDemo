package bob.spring.common;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CommonApplicationTests {
    @Autowired
    public RabbitmqConfig rabbitmqConfig;

    @Test
    void testRabbitmqConfig() {
        System.out.println(rabbitmqConfig.getRabbitmqServerUrl());
        System.out.println(rabbitmqConfig.getRabbitmqServerPort());
        System.out.println(rabbitmqConfig.getDemoQueueName());
        System.out.println(rabbitmqConfig.getDemoExchangeName());
    }

}

