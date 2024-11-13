package com.whhc;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MqDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private RabbitTemplate rabbitTemplate;
}
