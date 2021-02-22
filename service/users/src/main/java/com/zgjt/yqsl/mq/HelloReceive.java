package com.zgjt.yqsl.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
public class HelloReceive {


    @RabbitListener(queues = "TestDirectQueue")
    @RabbitHandler
    public void process(String hello) {
        System.out.println("第一个消费者  : " + hello);
    }

    @RabbitListener(queues = "TestDirectQueue")
    @RabbitHandler
    public void process1(String hello) {
        System.out.println("第二个消费者  : " + hello);
    }

    @RabbitListener(queues = "topic.man")
    @RabbitHandler
    public void process3(String hello) {
        System.out.println("第三个消费者  : " + hello);
    }

    @RabbitListener(queues = "topic.woman")
    @RabbitHandler
    public void process4(String hello) {
        System.out.println("第四个消费者  : " + hello);
    }

    @RabbitListener(queues = "fanout.A")
    @RabbitHandler
    public void process5(String hello) {
        System.out.println("第五个消费者  : " + hello);
    }

    @RabbitListener(queues = "fanout.B")
    @RabbitHandler
    public void process6(String hello) {
        System.out.println("第六个消费者  : " + hello);
    }

    @RabbitListener(queues = "fanout.C")
    @RabbitHandler
    public void process7(String hello) {
        System.out.println("第七个消费者  : " + hello);
    }
}
