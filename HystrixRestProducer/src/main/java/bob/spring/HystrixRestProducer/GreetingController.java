package bob.spring.HystrixRestProducer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface GreetingController {
    @GetMapping("/greeting/{username}")
    String greeting(@PathVariable("username") String username);
}