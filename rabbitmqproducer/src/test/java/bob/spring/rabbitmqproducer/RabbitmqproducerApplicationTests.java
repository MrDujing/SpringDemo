package bob.spring.rabbitmqproducer;

import bob.spring.rabbitmqcommon.RabbitmqConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class RabbitmqproducerApplicationTests {
    @Resource
    public RabbitmqConfig rabbitmqConfig;

    @Test
    public void testConfig() {
        System.out.println(rabbitmqConfig.getDemoExchangeName());
    }

}
