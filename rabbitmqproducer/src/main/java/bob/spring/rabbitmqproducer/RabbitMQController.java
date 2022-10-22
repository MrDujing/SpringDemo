package bob.spring.rabbitmqproducer;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/rabbitmq")
public class RabbitMQController {
    @Resource
    private RabbitMQService rabbitMQService;

    @PostMapping("/sendMsg")
    public String sendMsg(@RequestParam(name = "msg") String msg){
        return rabbitMQService.sendMsg(msg);
    }
}
