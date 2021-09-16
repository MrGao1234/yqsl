package com.zgjt.yqsl.controller;

import com.zgjt.yqsl.entity.GoodsBlock;
import com.zgjt.yqsl.response.ResponseApi;
import com.zgjt.yqsl.service.GoodsBlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-10-12
 */
@RestController
@RequestMapping("/goodsBlock")
public class GoodsBlockController {

    @Autowired
    private GoodsBlockService goodsBlockService;

    @PostMapping("/addBlock")
    public ResponseApi addGoods(GoodsBlock g){
        if(goodsBlockService.save(g)){
            return ResponseApi.sucess();
        }else{
            return ResponseApi.error();
        }
    }

    @PostMapping("/delBlock")
    public ResponseApi delGoods(int id){
        if(goodsBlockService.removeById(id)){
            return ResponseApi.sucess();
        }else{
            return ResponseApi.error();
        }
    }

    @PostMapping("/updBlock")
    public ResponseApi updGoods(GoodsBlock g){
        if(goodsBlockService.updateById(g)){
            return ResponseApi.sucess();
        }else{
            return ResponseApi.error();
        }
    }

    @GetMapping("/selBlock")
    public ResponseApi selGoods(){
        return ResponseApi.sucess().data(goodsBlockService.getMap(null));
    }
}

