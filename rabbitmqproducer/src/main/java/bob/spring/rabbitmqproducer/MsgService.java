package bob.spring.rabbitmqproducer;

import bob.spring.rabbitmqcommon.RabbitmqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class MsgService implements RabbitMQService{
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Resource
    private RabbitTemplate rabbitTemplate;
    @Resource
    private RabbitmqConfig rabbitmqConfig;

    @Override
    public String sendMsg(String msg) {
        String msgId = UUID.randomUUID().toString().replace("-", "").substring(0, 32);
        String sendTime = sdf.format(new Date());
        Map<String, Object> map = new HashMap<>();
        map.put("msgId", msgId);
        map.put("sendTime", sendTime);
        map.put("msg", msg);
        rabbitTemplate.convertAndSend(rabbitmqConfig.getDemoExchangeName(), rabbitmqConfig.getDemoRoutingKey(), map);
        return sdf.toString() + ": succeed send";
    }

}
