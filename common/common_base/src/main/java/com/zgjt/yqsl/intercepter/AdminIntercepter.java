package com.zgjt.yqsl.intercepter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zgjt.yqsl.execption.ExceptionCode;
import com.zgjt.yqsl.response.ResponseApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@Component
public class AdminIntercepter implements HandlerInterceptor {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)  {

        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
            log.info("OPTIONS请求，放行");
            return true;
        }

        String token = request.getHeader("token");

        log.info("拦截器---token {}",token);

        int code = ExceptionCode.SUCCESS_CODE;

        if(token == null || token.length() <= 0){
            code = ExceptionCode.TOKEN_ERROR_CODE;
        }else if(redisTemplate.opsForValue().get(token) == null){
            code = ExceptionCode.NO_LOGIN_CODE;
        }

        if(code != ExceptionCode.SUCCESS_CODE){
            PrintWriter writer;
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            try {
                writer = response.getWriter();
                writer.println(new ObjectMapper().writeValueAsString( ResponseApi.error().code(code) ));
                writer.close();
            } catch (IOException e) {
                log.error("writer 流异常：{}",e);
            }
            return false;
        }
        return true;
    }
}
