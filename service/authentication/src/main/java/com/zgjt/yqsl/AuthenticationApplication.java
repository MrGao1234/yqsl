package com.zgjt.yqsl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author admin
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan({"com.zgjt.yqsl.mapper","com.zgjt.yqsl.*.mapper"})
public class AuthenticationApplication {

    public static void main(String[] args){
        SpringApplication.run(AuthenticationApplication.class, args);
    }
}
