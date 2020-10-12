package com.zgjt.yqsl.response;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ResponseApi {

    private boolean success;
    private Integer code;
    private String message;
    private Map<String, Object> data = new HashMap<>();

    private ResponseApi(){}

    public static ResponseApi sucess() {
        ResponseApi r = new ResponseApi();
        r.setSuccess(true);
        r.setCode(ResponseCode.SUCCESS);
        r.setMessage("成功");
        return r;
    }

    //失败静态方法
    public static ResponseApi error() {
        ResponseApi r = new ResponseApi();
        r.setSuccess(false);
        r.setCode(ResponseCode.ERROR);
        r.setMessage("失败");
        return r;
    }


    public ResponseApi message(String message){
        this.setMessage(message);
        return this;
    }

    public ResponseApi code(Integer code){
        this.setCode(code);
        return this;
    }

    public ResponseApi data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public ResponseApi data(Map<String, Object> map){
        this.setData(map);
        return this;
    }

}
