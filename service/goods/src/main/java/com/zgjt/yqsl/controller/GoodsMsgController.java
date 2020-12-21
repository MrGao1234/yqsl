package com.zgjt.yqsl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zgjt.yqsl.entity.BaseUnit;
import com.zgjt.yqsl.entity.GoodsMsg;
import com.zgjt.yqsl.response.ResponseApi;
import com.zgjt.yqsl.service.BaseUnitService;
import com.zgjt.yqsl.service.GoodsMsgService;
import com.zgjt.yqsl.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goodsMsg")
public class GoodsMsgController {

    @Autowired
    private GoodsMsgService goodsMsgService;

    @Autowired
    private BaseUnitService baseUnitService;

    @PostMapping("addGoodsMsg")
    public ResponseApi addGoodsMsg(@RequestBody GoodsMsg goodsMsg){
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
    public ResponseApi updGoodsMsg(@RequestBody GoodsMsg g){
        if(goodsMsgService.updateById(g)){
            return ResponseApi.sucess();
        }else{
            return ResponseApi.error();
        }
    }

    @PostMapping("selGoodsMsg")
    public ResponseApi selGoodsMsg(@RequestBody PageVo pageVo){
        IPage<GoodsMsg> goodsMsgList = goodsMsgService.findGoodsMsg(pageVo);
        return ResponseApi.sucess().put(goodsMsgList);
    }

    @GetMapping("selUnit")
    public ResponseApi selUnit(String type){
        QueryWrapper<BaseUnit> wrapper = new QueryWrapper<>();
        wrapper.eq("type",type);
        return ResponseApi.sucess().put(baseUnitService.list(wrapper));
    }
}
