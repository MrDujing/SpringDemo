package bob.spring.rabbitmqconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "bob.spring")
public class RabbitmqconsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqconsumerApplication.class, args);
    }

}
