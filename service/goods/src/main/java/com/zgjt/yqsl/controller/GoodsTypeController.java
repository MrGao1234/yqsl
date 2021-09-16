package com.zgjt.yqsl.controller;

import com.zgjt.yqsl.entity.GoodsType;
import com.zgjt.yqsl.response.ResponseApi;
import com.zgjt.yqsl.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

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

    @PostMapping("/addGoodsType")
    public ResponseApi addGoodsType(@RequestBody GoodsType g){
        if( GoodsTypeService.save(g) ){
            return ResponseApi.sucess();
        }else{
            return ResponseApi.error();
        }
    }

    @PostMapping("/delGoodsType")
    public ResponseApi delGoodsType(int id){
        if(GoodsTypeService.removeById(id)){
            return ResponseApi.sucess();
        }else{
            return ResponseApi.error();
        }
    }

    @PostMapping("/updGoodsType")
    public ResponseApi updGoodsType(@RequestBody GoodsType g){
        if(GoodsTypeService.updateById(g)){
            return ResponseApi.sucess();
        }else{
            return ResponseApi.error();
        }
    }

    @GetMapping("/selGoodsType")
    public ResponseApi selGoodsType(){
        return ResponseApi.sucess().data("typeList",GoodsTypeService.goodsTypeList());
    }

    @GetMapping("test")
    public void test() throws IOException {
        String name = System.getProperty("os.name");
        System.out.println(name);
    }

}

