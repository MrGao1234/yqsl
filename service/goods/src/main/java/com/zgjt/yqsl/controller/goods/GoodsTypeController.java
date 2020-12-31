package com.zgjt.yqsl.controller.goods;


import com.zgjt.yqsl.annotation.AuthorityAnnotation;
import com.zgjt.yqsl.entity.GoodsType;
import com.zgjt.yqsl.response.ResponseApi;
import com.zgjt.yqsl.service.GoodsTypeService;
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
@RequestMapping("/goodsType")
public class GoodsTypeController {

    @Autowired
    private GoodsTypeService GoodsTypeService;

    @AuthorityAnnotation(value = {1})
    @PostMapping("addGoodsType")
    public ResponseApi addGoodsType(GoodsType g){
        if( GoodsTypeService.save(g) ){
            return ResponseApi.sucess();
        }else{
            return ResponseApi.error();
        }
    }

    @AuthorityAnnotation(value = {1})
    @PostMapping("delGoodsType")
    public ResponseApi delGoodsType(int id){
        if(GoodsTypeService.removeById(id)){
            return ResponseApi.sucess();
        }else{
            return ResponseApi.error();
        }
    }

    @AuthorityAnnotation(value = {1})
    @PostMapping("updGoodsType")
    public ResponseApi updGoodsType(GoodsType g){
        if(GoodsTypeService.updateById(g)){
            return ResponseApi.sucess();
        }else{
            return ResponseApi.error();
        }
    }

    @GetMapping("selGoodsType")
    public ResponseApi selGoodsType(){
        return ResponseApi.sucess().data("typeList",GoodsTypeService.list(null));
    }

}

