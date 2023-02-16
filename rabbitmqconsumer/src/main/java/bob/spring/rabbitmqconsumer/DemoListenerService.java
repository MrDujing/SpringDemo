package bob.spring.rabbitmqconsumer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Service;


@Service
public class DemoListenerService implements ChannelAwareMessageListener {

    @Override
    public void onMessage(Message message, Channel channel) {
        byte[] body = message.getBody();
        System.out.println("Receive msg: " + new String(body));
    }
}

