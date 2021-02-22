package com.zgjt.yqsl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zgjt.yqsl.entity.PowerShop;
import com.zgjt.yqsl.mapper.PowerShopMapper;
import com.zgjt.yqsl.service.PowerShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PowerShopServiceImpl extends ServiceImpl<PowerShopMapper, PowerShop> implements PowerShopService {

    @Autowired
    private PowerShopMapper powerShopMapper;

    public List<PowerShop> findPowerShopList(String name){
        return powerShopMapper.findPowerShop(name);
    }
}
