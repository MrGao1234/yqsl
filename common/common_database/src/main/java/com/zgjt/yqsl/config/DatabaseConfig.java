package com.zgjt.yqsl.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.zgjt.yqsl.multiple.MultipleDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DatabaseConfig {

    public static final String READ = "read";
    public static final String WRITE = "write";

    @Bean(name = READ)
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    public DataSource db1() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = WRITE)
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public DataSource db2() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public DataSource multipleDataSource(@Qualifier(READ) DataSource db1, @Qualifier(WRITE) DataSource db2) {
        MultipleDataSource multipleDataSource = new MultipleDataSource();
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(READ, db1);
        targetDataSources.put(WRITE, db2);

        //添加数据源
        multipleDataSource.setTargetDataSources(targetDataSources);

        //默认数据源
        multipleDataSource.setDefaultTargetDataSource(db1);
        return multipleDataSource;
    }
}
