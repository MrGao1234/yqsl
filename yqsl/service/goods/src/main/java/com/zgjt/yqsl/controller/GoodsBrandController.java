package com.zgjt.yqsl.controller;

import com.zgjt.yqsl.entity.GoodsBrand;
import com.zgjt.yqsl.response.ResponseApi;
import com.zgjt.yqsl.service.GoodsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brand")
public class GoodsBrandController {

    @Autowired
    private GoodsBrandService goodsBrandService;

    @PostMapping("/addBrand")
    public ResponseApi addGoods(GoodsBrand g){
        if(goodsBrandService.save(g)){
            return ResponseApi.sucess();
        }else{
            return ResponseApi.error();
        }
    }

    @PostMapping("/delBrand")
    public ResponseApi delGoods(int id){
        if(goodsBrandService.removeById(id)){
            return ResponseApi.sucess();
        }else{
            return ResponseApi.error();
        }
    }

    @PostMapping("/updBrand")
    public ResponseApi updGoods(GoodsBrand g){
        if(goodsBrandService.updateById(g)){
            return ResponseApi.sucess();
        }else{
            return ResponseApi.error();
        }
    }

    @GetMapping("/selGoods")
    public ResponseApi selGoods(){
        return ResponseApi.sucess().data(goodsBrandService.getMap(null));
    }
}
