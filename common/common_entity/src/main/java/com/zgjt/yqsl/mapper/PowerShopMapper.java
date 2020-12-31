package com.zgjt.yqsl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zgjt.yqsl.entity.PowerShop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PowerShopMapper extends BaseMapper<PowerShop> {

    List<PowerShop> findPowerShop(@Param("name") String name);
}
