package bob.spring.rabbitmqproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "bob.spring")
public class RabbitmqproducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RabbitmqproducerApplication.class, args);
    }
}
