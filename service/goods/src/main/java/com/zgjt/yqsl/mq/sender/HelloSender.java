package com.zgjt.yqsl.mq.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class HelloSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(){
        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        rabbitTemplate.convertAndSend("TestDirectExchange","TestDirectRouting", context);
    }


}
