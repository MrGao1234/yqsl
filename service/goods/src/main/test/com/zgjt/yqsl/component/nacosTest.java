package com.zgjt.yqsl.component;

import com.zgjt.yqsl.GoodsApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GoodsApplication.class)
@RefreshScope
public class nacosTest {

    @Value("${useLocalCache:false}")
    private String test;

    //nacos 配置中心
    @Test
    public void test(){

        System.out.println();
        System.out.println(test);

    }

}
