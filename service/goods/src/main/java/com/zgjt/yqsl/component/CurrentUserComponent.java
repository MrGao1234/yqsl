package com.zgjt.yqsl.component;

import com.zgjt.yqsl.entity.PowerUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
public class CurrentUserComponent {

    @Autowired
    private RedisTemplate redisTemplate;

    //获取 redis 缓存中的 user
    public PowerUser findCurrentUser(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("token");
        PowerUser powerUser = (PowerUser)redisTemplate.opsForValue().get(token);
        return powerUser;
    }
}
