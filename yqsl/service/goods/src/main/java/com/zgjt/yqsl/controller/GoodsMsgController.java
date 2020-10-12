package com.zgjt.yqsl.controller;

import com.zgjt.yqsl.entity.GoodsMsg;
import com.zgjt.yqsl.response.ResponseApi;
import com.zgjt.yqsl.service.GoodsMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goodsMsg")
public class GoodsMsgController {

    @Autowired
    private GoodsMsgService goodsMsgService;

    @PostMapping("addGoodsMsg")
    public ResponseApi addGoodsMsg(GoodsMsg goodsMsg){
        if( goodsMsgService.save(goodsMsg) ){
            return ResponseApi.sucess();
        }else{
            return ResponseApi.error();
        }
    }

    @PostMapping("delGoodsMsg")
    public ResponseApi delGoodsMsg(int id){
        if(goodsMsgService.removeById(id)){
            return ResponseApi.sucess();
        }else{
            return ResponseApi.error();
        }
    }

    @PostMapping("updGoodsMsg")
    public ResponseApi updGoodsMsg(GoodsMsg g){
        if(goodsMsgService.updateById(g)){
            return ResponseApi.sucess();
        }else{
            return ResponseApi.error();
        }
    }

    @GetMapping("selGoodsMsg")
    public ResponseApi selGoodsMsg(){
        return ResponseApi.sucess().data(goodsMsgService.getMap(null));
    }
}
