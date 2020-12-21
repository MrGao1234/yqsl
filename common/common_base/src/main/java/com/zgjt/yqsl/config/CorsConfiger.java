package com.zgjt.yqsl.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.io.File;

@Configuration
public class CorsConfiger extends WebMvcConfigurationSupport {

    /*
        跨域问题
        addMapping：表示允许访问的路径
        allowedMethods：表示允许访问的方法
        allowedOrigins：表示允许访问的用户
        allowHeaders：头部信息
    */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH")
                .allowedOrigins("*")
                .maxAge(3600)
                .allowCredentials(true)
                .allowedHeaders("*");
        super.addCorsMappings(registry);
    }

    /*
     *   功能描述:
     *   配置静态资源,避免静态资源请求被拦截
     * */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:resources/", "classpath:static/",
                        "classpath:public/", "classpath:META-INF/resources/")
                .addResourceLocations("file:" + new File("").getAbsolutePath() + "//");
    }
}
