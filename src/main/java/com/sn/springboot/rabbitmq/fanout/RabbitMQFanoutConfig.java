package com.sn.springboot.rabbitmq.fanout;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Fanout Exchange 会忽略 RoutingKey 的设置，直接将 Message 路由到所有绑定的 Queue 中。
 */
@Configuration
public class RabbitMQFanoutConfig {
    public static final String FANOUT_NAME = "my_fanout";

    @Value("${rabbitmq.queue2}")
    private String queue2;

    @Value("${rabbitmq.queue3}")
    private String queue3;

    @Bean
    public Queue queue2() {
        return new Queue(queue2);
    }

    @Bean
    public Queue queue3() {
        return new Queue(queue3);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_NAME, true, false);
    }

    @Bean
    public Binding binding2() {
        return BindingBuilder.bind(queue2()).to(fanoutExchange());
    }

    @Bean
    public Binding binding3() {
        return BindingBuilder.bind(queue3()).to(fanoutExchange());
    }
}
