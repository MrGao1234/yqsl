package com.zgjt.yqsl.config;

import com.zgjt.yqsl.intercepter.AdminIntercepter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

//@Configuration
public class CorsConfiger extends WebMvcConfigurationSupport {

    /*提前将拦截器拿出，取代注册的时候 new，这样 redisTemplate 才不会为空*/
    @Bean
    public AdminIntercepter getLoginHandlerInterceptor(){
        return new AdminIntercepter();
    }

    /*
     *   功能描述:
     *   配置静态资源,避免静态资源请求被拦截
     * */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:resources/", "classpath:static/",
                        "classpath:public/", "classpath:META-INF/resources/");
    }

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

    /*登录拦截器*/
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        InterceptorRegistration registration = registry.addInterceptor(getLoginHandlerInterceptor());
        //拦截所有路径
        registration.addPathPatterns("/**")
                .excludePathPatterns("/login/**")
                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
    }
}
