package com.zgjt.yqsl.controller;

import org.springframework.beans.factory.annotation.Value;
import com.zgjt.yqsl.mq.sender.HelloSender;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class Test {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private HelloSender helloSender;

    @PostMapping("/login/test")
    public void test(){
        for(int i = 0;i < 10;i++){
            helloSender.send();
        }
    }

    @PostMapping("/login/test1")
    public void test1(){
        rabbitTemplate.convertAndSend("topicExchange","topic.man","hello test1");
    }

    @PostMapping("/login/test2")
    public void test2(){
        rabbitTemplate.convertAndSend("topicExchange","topic.woman","hello test2");
    }

    @PostMapping("/login/test3")
    public void test3(){
        rabbitTemplate.convertAndSend("fanoutExchange",null,"hello test3");
    }

    @PostMapping("/login/test4")
    public void test4(){
        rabbitTemplate.convertAndSend("no-exist-exchange","no-exist-query","hello test4");
    }

    @PostMapping("/login/test5")
    public void test5(){
        rabbitTemplate.convertAndSend("topicExchange","no-exist-query","hello test5");
    }

    @Value("${test}")
    private String useLocalCache;

    @PostMapping("/login/get")
    public void get() {
        System.out.println( useLocalCache );
    }

}
