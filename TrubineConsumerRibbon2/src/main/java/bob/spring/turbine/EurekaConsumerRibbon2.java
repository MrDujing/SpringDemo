package bob.spring.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableDiscoveryClient
public class EurekaConsumerRibbon2 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumerRibbon2.class, args);
    }
}
