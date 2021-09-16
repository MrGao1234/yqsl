package com.zgjt.yqsl.service.impl;

import com.zgjt.yqsl.entity.PowerUser;
import com.zgjt.yqsl.mapper.PowerUserMapper;
import com.zgjt.yqsl.response.ResponseApi;
import com.zgjt.yqsl.service.AuthenticationService;
import com.zgjt.yqsl.utils.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * @author admin
 */
@Service
public class AuthenticationImpl implements AuthenticationService {

    @Autowired
    private PowerUserMapper powerUserMapper;

    /**
     * 账号密码
     * */
    @Override
    public ResponseApi loginByAccountAndPassword(String account, String password) {

        PowerUser powerUser = powerUserMapper.findPowerUserByAccount(account);
        if(powerUser == null){
            return ResponseApi.error().message("该用户不存在！");
        }
        if( !DigestUtils.md5DigestAsHex(password.getBytes()).equals(powerUser.getUserPwd()) ){
            return ResponseApi.error().message("用户密码错误！");
        }
        return ResponseApi.sucess().message( JwtUtil.generateJwt(powerUser) );
    }

}
