package com.zgjt.yqsl.component;

import com.zgjt.yqsl.GoodsApplication;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

@SpringBootTest(classes = GoodsApplication.class)
public class JasyptApplicationTests {
    @Autowired
    private StringEncryptor stringEncryptor;

    @Test
    public void testPassword(){
        //加密
        System.out.println(stringEncryptor.encrypt("LTAIxWRuPa823WZ9"));
        System.out.println(stringEncryptor.encrypt("DQXmA9Yl7pZSF8ij8VVcnq1a4drbRI"));
    }

    @Test
    public void md5Test(){
        System.out.println(DigestUtils.md5DigestAsHex("y_001".getBytes() ));
    }

    @Test
    public void codeTest(){
        System.out.println((int)((Math.random()*9+1)*100000));
    }
}
