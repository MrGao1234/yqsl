package com.zgjt.yqsl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zgjt.yqsl.entity.PowerShop;

import java.util.List;

public interface PowerShopService extends IService<PowerShop> {
    List<PowerShop> findPowerShopList(String name);
}
