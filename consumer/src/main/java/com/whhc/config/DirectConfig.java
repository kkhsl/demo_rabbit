package com.whhc.config;

import org.springframework.amqp.core.*;
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
public class DirectConfig {


    //  基于RabbitListener注解来声明队列和交换机的方式
    @RabbitListener(bindings = @QueueBinding(
            value = @org.springframework.amqp.rabbit.annotation.Queue(name = "direct.queue1"),
            exchange = @Exchange(name = "whhc.direct", type = ExchangeTypes.DIRECT),
            key = {"red", "blue"}))
    public void listenerDirectQueue1(String message){
        System.out.println("消费者 queue1 接收到Direct消息：【"+ message +"】");
    }

    //  基于RabbitListener注解来声明队列和交换机的方式
    @RabbitListener(bindings = @QueueBinding(
            value = @org.springframework.amqp.rabbit.annotation.Queue(name = "direct.queue2"),
            exchange = @Exchange(name = "whhc.direct", type = ExchangeTypes.DIRECT),
            key = {"red", "yellow"}))
    public void listenerDirectQueue2(String message){
        System.out.println("消费者 queue2 接收到Direct消息：【"+ message +"】");
    }

}
