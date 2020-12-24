package com.zgjt.yqsl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zgjt.yqsl.entity.BaseImg;
import com.zgjt.yqsl.entity.PowerShop;
import com.zgjt.yqsl.entity.PowerUser;
import com.zgjt.yqsl.response.ResponseApi;
import com.zgjt.yqsl.service.BaseImgService;
import com.zgjt.yqsl.service.PowerShopService;
import com.zgjt.yqsl.service.PowerUserService;
import com.zgjt.yqsl.utils.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/shop")
public class PowerShopController {

    @Autowired
    private PowerShopService powerShopService;

    @Autowired
    private PowerUserService powerUserService;

    @Autowired
    private BaseImgService baseImgService;

    //店铺列表
    @GetMapping("/shopList")
    public ResponseApi findShopList(String name){
        List<PowerShop> list = powerShopService.findPowerShopList(name);
        return ResponseApi.sucess().put(list);
    }

    //注册店铺
    @PostMapping("registerShop")
    @Transactional
    public ResponseApi registerShop(@RequestBody PowerShop powerShop){

        powerShop.setId(RandomUtils.getGUID());

        //店长
        powerUserService.updateDirector(powerShop.getId(),powerShop.getDirector().getId());

        //更改图片
        List<String> list = powerShop.getBaseImgList();
        List<BaseImg> imgList = new ArrayList<>();
        for(String str:list){
            BaseImg img = new BaseImg();
            img.setAvartal(str);
            img.setTableName("power_shop");
            img.setTableRowId(powerShop.getId());
            imgList.add(img);
        }
        baseImgService.saveBatch(imgList);

        powerShopService.save(powerShop);
        return ResponseApi.sucess();
    }

    //注销店铺
    @PostMapping("cancalShop")
    @Transactional
    public ResponseApi cancalShop(String id,int userId){

        powerUserService.updateDirector("1",userId);

        powerShopService.removeById(id);
        return ResponseApi.sucess();
    }
}
