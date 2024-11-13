package com.whhc.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author HKK
 * @version 1.0
 * @date 2024-04-24 17:32
 * <p>
 * 广播
 */
@Configuration
public class FanoutConfig {

    // 声明FanoutExchange交换机
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("whhc.fanout");
    }

    // 声明一个队列
    @Bean
    public Queue fanoutQueue1() {
        return new Queue("fanout.queue1");
    }

    // 绑定队列和交换机
    @Bean
    public Binding bindingQueue1(Queue fanoutQueue1, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue1).to(fanoutExchange);
    }

    // 声明一个队列
    @Bean
    public Queue fanoutQueue2() {
        return new Queue("fanout.queue2");
    }

    // 绑定队列和交换机
    @Bean
    public Binding bindingQueue2(Queue fanoutQueue2, FanoutExchange fanoutExchange) {
        return BindingBuilder
                .bind(fanoutQueue2())
                .to(fanoutExchange);
    }

}
