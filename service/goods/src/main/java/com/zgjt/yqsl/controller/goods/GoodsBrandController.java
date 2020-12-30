package com.zgjt.yqsl.controller.goods;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zgjt.yqsl.entity.GoodsBrand;
import com.zgjt.yqsl.response.ResponseApi;
import com.zgjt.yqsl.service.GoodsBrandService;
import com.zgjt.yqsl.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brand")
public class GoodsBrandController {

    @Autowired
    private GoodsBrandService goodsBrandService;

    @PostMapping("/addBrand")
    public ResponseApi addGoods(@RequestBody GoodsBrand g){
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
    public ResponseApi updGoods(@RequestBody GoodsBrand g){
        if(goodsBrandService.updateById(g)){
            return ResponseApi.sucess();
        }else{
            return ResponseApi.error();
        }
    }



    @PostMapping("/selBrands")
    public ResponseApi selGoods(@RequestBody PageVo pageVo){
        QueryWrapper<GoodsBrand> wrapper = new QueryWrapper<>();
        if(pageVo.getName() != null && pageVo.getName().length() > 0){
            wrapper.like("name",pageVo.getName());
        }

        //这是查询所有的，不分页
        if(pageVo.getPageSize() == 0 && pageVo.getPageNumber() == 0){
            return ResponseApi.sucess().data("brandList",goodsBrandService.list(wrapper));
        }
        wrapper.orderByDesc("create_time");
        IPage<GoodsBrand> page = goodsBrandService.page(new Page<>(pageVo.getPageNumber(), pageVo.getPageSize()),wrapper);

        return ResponseApi.sucess().data("brandList",page);
    }
}
