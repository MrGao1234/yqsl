package com.zgjt.yqsl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zgjt.yqsl.entity.PowerUser;
import com.zgjt.yqsl.execption.MyExecption;
import com.zgjt.yqsl.mapper.PowerUserMapper;
import com.zgjt.yqsl.service.PowerLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class PowerLoginServiceImpl extends ServiceImpl<PowerUserMapper, PowerUser> implements PowerLoginService {

    @Autowired
    private PowerUserMapper powerUserMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public String varifyLoginMessage(String verifyCodeId,HttpServletResponse response, String account, String password, String verifyCode) {

        //先来判断验证码
        if( !verifyCode.equals(redisTemplate.opsForValue().get(verifyCodeId)) ){
            throw new MyExecption(20001,"验证码错误！");
        }

        QueryWrapper<PowerUser> wrapper = new QueryWrapper<>();
        wrapper.eq("user_pwd", DigestUtils.md5DigestAsHex(password.getBytes()));
        //判断账号是否纯数字
        boolean accountFlag = account.matches("[0-9]+");
        if(accountFlag){
            //纯数字为号码
            wrapper.eq("telephone",account);
        }else{
            //否则是账号
            wrapper.eq("account",account);
        }
        PowerUser user = powerUserMapper.selectOne(wrapper);
        return cacheUser(response,user);
    }

    @Override
    public String varifyLoginByCode(HttpServletResponse response,String phone, String code) {
        QueryWrapper<PowerUser> wrapper = new QueryWrapper<>();
        if(code == null){
            throw new MyExecption(20001,"code不能为空");
        }
        if(redisTemplate.opsForValue().get(phone) == null){
            throw new MyExecption(20001,"验证码已过期");
        }
        if(code.equals(redisTemplate.opsForValue().get(phone).toString())) {
            wrapper.eq("telephone", phone);
        }else{
            throw new MyExecption(20001,"验证失败");
        }
        PowerUser user = powerUserMapper.selectOne(wrapper);
        return cacheUser(response,user);
    }

    @Override
    public String cacheUser(HttpServletResponse response,PowerUser user){
        if(user == null) return null;
        String uuid = UUID.randomUUID().toString().replace("-","");

        log.info("返回的token: {}",uuid);

        redisTemplate.opsForValue().set(uuid,user,12, TimeUnit.HOURS);
        response.addHeader("token",uuid);
        return uuid;
    }

}
