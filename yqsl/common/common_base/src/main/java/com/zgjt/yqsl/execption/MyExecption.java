package com.zgjt.yqsl.execption;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyExecption extends RuntimeException{

    private Integer code;
    private String msg;
}
