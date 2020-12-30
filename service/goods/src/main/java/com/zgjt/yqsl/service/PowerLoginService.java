package com.zgjt.yqsl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zgjt.yqsl.entity.PowerUser;

import javax.servlet.http.HttpServletResponse;

public interface PowerLoginService extends IService<PowerUser> {

    String varifyLoginMessage(String verifyCodeId,HttpServletResponse response, String account, String password, String verifyCode);

    String varifyLoginByCode(HttpServletResponse response,String phone,String code);

    String cacheUser(HttpServletResponse response,PowerUser user);

}
