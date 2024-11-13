package com.whhc.amqp.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.converter.MessageConversionException;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author HKK
 * @version 1.0
 * @date 2024-04-23 15:51
 */
@Slf4j
@Component
public class SpringRabbitListener {

    @RabbitListener(queues = "simple.queue")
    public void lisenerSimpleQueueMessage(String message){
        log.info("spring 消费者接收到消息：[" + message + "]");
//        if(true){
//            throw new MessageConversionException("故意的");
//        }
        log.info("消息处理完成");
    }


//    @RabbitListener(queues = "work.queue")
//    public void listenerWorkQueue_1(String message){
//        log.info("消费者 1 接收到 work.queue1 消息：[" + message + "]");
//    }
//
//    @RabbitListener(queues = "work.queue")
//    public void listenerWorkQueue_2(String message){
//        log.info("消费者 2 接收到 work.queue2 消息：[" + message + "]");
//    }
//
    @RabbitListener(queues = "fanout.queue1")
    public void listenerFanoutQueue_1(String message){
        log.info("消费者 1 接收到 fanout.queue1 消息：[" + message + "]");
    }

    @RabbitListener(queues = "fanout.queue2")
    public void listenerFanoutQueue_2(String message){
        log.info("消费者 2 接收到 fanout.queue2 消息：[" + message + "]");
    }

//    @RabbitListener(queues = "direct.queue1")
//    public void listenerDirectQueue_1(String message){
//        log.info("消费者 1 接收到 direct.queue1 消息：[" + message + "]");
//    }
//
//    @RabbitListener(queues = "direct.queue2")
//    public void listenerDirectQueue_2(String message){
//        log.info("消费者 2 接收到 direct.queue2 消息：[" + message + "]");
//    }
//
//    // 基于RabbitListener注解来声明队列和交换机的方式
//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue(name = "direct.queue3"),
//            exchange = @Exchange(name = "whhc.direct2", type = ExchangeTypes.DIRECT),
//            key = {"red", "blue"}))
//    public void listenerDirectQueue3(String message){
//        System.out.println("消费者 1 接收到Direct消息：【"+ message +"】");
//    }
//
//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue(name = "direct.queue4"),
//            exchange = @Exchange(name = "whhc.direct2", type = ExchangeTypes.DIRECT),
//            key = {"red", "green"}))
//    public void listenerDirectQueue4(String message){
//        System.out.println("消费者 1 接收到Direct消息：【"+ message +"】");
//    }
//
//
//    @RabbitListener(queues = "object.queue")
//    public void listenerObjectQueue(Map<String, Object> message){
//        log.info("消费者接收到 object.queue 消息：[" + message + "]");
//    }
}
