package com.zgjt.yqsl.execption;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class MyExecption extends RuntimeException{

    private Integer code;
    private String msg;

    public MyExecption(){}

    public MyExecption(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }
}
