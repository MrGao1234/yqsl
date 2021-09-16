package com.zgjt.yqsl.service;

import com.zgjt.yqsl.response.ResponseApi;

/**
 * @author admin
 */
public interface AuthenticationService {

    /**
     * 根据用户名密码登录
     * @param account 账号
     * @param password 密码
     * @return Result<PowerUser> 用户信息
     */
    ResponseApi loginByAccountAndPassword(String account, String password);

}
