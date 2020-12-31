package com.zgjt.yqsl.execption;

public interface ExceptionCode {

    int SUCCESS_CODE = 20000; //正常
    int ERROR_CODE = 20001;   //发生异常
    int TOKEN_ERROR_CODE = 20002; //token 错误
    int NO_LOGIN_CODE = 20003; //尚未登录
    int DUTY_CODE = 20004; //权限不足
}
