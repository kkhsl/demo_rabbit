package com.whhc;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class PublisherApplicationTests {

    @Test
    void contextLoads() {
    }


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSendMessage2Queue(){
        String queuename = "simple.queue";
        String message = "hello, amqp!";
        rabbitTemplate.convertAndSend(queuename, message);
    }

    @Test
    public void testWorkQueue() throws InterruptedException {
        for (int i = 1; i <= 50 ; i++) {
            String queuename = "work.queue";
            String message = "hello, work message_" + i;
            rabbitTemplate.convertAndSend(queuename, message);
            Thread.sleep(20);
        }
    }


    // Fanout 广播
    @Test
    public void testFanoutQueue() throws InterruptedException {
        String queuename = "whhc.fanout";
        String message = "hello, fanout message";
        rabbitTemplate.convertAndSend(queuename, null, message);
    }

    // direct 定向消息发送
    @Test
    public void testDirectQueue() throws InterruptedException {
        String color = "red";

        String queuename = "whhc.direct";
        String message = "direct " + color;

        rabbitTemplate.convertAndSend(queuename, color, message);
    }

    // topic 定向消息发送
    @Test
    public void testTopicQueue() throws InterruptedException {
        String color = "china.weather";

        String queuename = "whhc.topic";
        String message = "hello, topic message";
        rabbitTemplate.convertAndSend(queuename, color, message);
    }

    @Test
    public void testObjectQueue() throws InterruptedException {

        String queuename = "object.queue";
        Map<String, Object> msg = new HashMap<>();
        msg.put("name", "jack");
        msg.put("age", 27);
        rabbitTemplate.convertAndSend(queuename, msg);
    }
}
