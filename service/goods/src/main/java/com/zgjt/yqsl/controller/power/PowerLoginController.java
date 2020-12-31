package com.zgjt.yqsl.controller.power;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zgjt.yqsl.entity.PowerUser;
import com.zgjt.yqsl.response.ResponseApi;
import com.zgjt.yqsl.service.PowerLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/login")
@Slf4j
public class PowerLoginController {

    @Autowired
    private PowerLoginService powerLoginService;

    /**
    *  登录：账号或者手机号 + 密码 + 验证码
     *  根据账号或者手机号都可以登录
     *  验证码验证，请求头带的字符串，去 redis 查询
    * */
    @PostMapping("/verifyByPassword")
    public ResponseApi loginByPassword(@RequestHeader("verifyCodeId") String verifyCodeId, HttpServletResponse response, String account, String password, String verifyCode){
        String uuid = powerLoginService.varifyLoginMessage(verifyCodeId,response,account,password,verifyCode);
        if(uuid != null && uuid.length() > 0){
            return ResponseApi.sucess().put("验证成功");
        }
        return  ResponseApi.error().put("验证失败");
    }

    /**
     * 登录：手机号 + 验证码
     * */
    @PostMapping("/verifyByVerifyCode")
    public ResponseApi loginByVerifyCode( HttpServletResponse response,String phone, String code){
        String uuid = powerLoginService.varifyLoginByCode(response,phone,code);
        if(uuid != null && uuid.length() > 0){
            return ResponseApi.sucess().put("验证成功");
        }
        return  ResponseApi.error().put("验证失败");
    }

    /**
     * 判断手机号是否存在
     * */
    @PostMapping("/hasRegisteredPhone")
    public ResponseApi hasRegisteredPhone(String phone){
        QueryWrapper<PowerUser> wrapper = new QueryWrapper<>();
        wrapper.eq("telephone",phone);
        if(powerLoginService.count(wrapper) > 0){
            return ResponseApi.error().message("该账号已被注册");
        }
        return ResponseApi.sucess();
    }
}
