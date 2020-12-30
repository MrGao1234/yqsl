package com.zgjt.yqsl.utils;

public class VerifyCodeUtils {

    public static String getSixCode(){
       return (int)((Math.random()*9+1)*100000)+"";
    }
}
