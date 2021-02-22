package com.zgjt.yqsl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan({"com.zgjt.yqsl.mapper","com.zgjt.yqsl.*.mapper"})
public class StoreApplication {
    public static void main(String[] args){
        SpringApplication.run(StoreApplication.class,args);
    }
}
