package com.zgjt.yqsl.controller;

import com.zgjt.yqsl.response.ResponseApi;
import com.zgjt.yqsl.service.AuthenticationService;
import com.zgjt.yqsl.utils.encryption.AesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 */
@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @Value("${aes.primary-key}")
    private String primaryKey;

    @PostMapping("/login")
    public ResponseApi login(String account, String password){
        try {
            account = AesUtil.aesDecrypt(account, primaryKey);
            password = AesUtil.aesDecrypt(password, primaryKey);
        } catch (Exception e) {
            return ResponseApi.error().message("解析数据异常！");
        }
        return authenticationService.loginByAccountAndPassword(account, password);
    }
}
