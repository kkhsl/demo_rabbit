package com.whhc.config;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

/**
 * @author HKK
 * @version 1.0
 * @date 2024-04-24 17:32
 *
 * 定向
 */
@Configuration
public class TopicConfig {

    @RabbitListener(bindings = @QueueBinding(
            value = @org.springframework.amqp.rabbit.annotation.Queue(name = "topic.queue1"),
            exchange = @Exchange(name = "whhc.topic", type = ExchangeTypes.TOPIC),
            key = {"china.#"}))
    public void listenerTopicQueue1(String message){
        System.out.println("消费者 queue1 接收到Topic消息：【"+ message +"】");
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @org.springframework.amqp.rabbit.annotation.Queue(name = "topic.queue2"),
            exchange = @Exchange(name = "whhc.topic", type = ExchangeTypes.TOPIC),
            key = {"#.new"}))
    public void listenerTopicQueue2(String message){
        System.out.println("消费者 queue2 接收到Topic消息：【"+ message +"】");
    }

}
