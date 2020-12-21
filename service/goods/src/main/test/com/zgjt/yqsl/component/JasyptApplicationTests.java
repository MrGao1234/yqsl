package com.zgjt.yqsl.component;

import com.zgjt.yqsl.GoodsApplication;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GoodsApplication.class)
public class JasyptApplicationTests {
    @Autowired
    private StringEncryptor stringEncryptor;

    @Test
    public void testPassword(){
        //加密
        System.out.println(stringEncryptor.encrypt("root"));
        System.out.println(stringEncryptor.encrypt("1234"));
    }
}
