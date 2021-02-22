package com.zgjt.yqsl.component;

import com.zgjt.yqsl.GoodsApplication;
import com.zgjt.yqsl.kafka.KafkaProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GoodsApplication.class)
public class KafkaController {
    @Autowired
    private KafkaProducer kafkaAdminClient;

    @Test
    public void sendMessage(){
        for(int i = 0;i <= 10;i++) {
            kafkaAdminClient.send("这是第 "+ i +" 条消息");
        }
    }
}
