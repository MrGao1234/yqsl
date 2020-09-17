package com.zgjt.yqsl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan("com.zgjt.yqsl.mapper")
public class GoodsApplication {
    public static void main(String[] args){
        SpringApplication.run(GoodsApplication.class,args);
    }
}
