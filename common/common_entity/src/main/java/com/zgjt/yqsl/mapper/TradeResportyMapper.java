package com.zgjt.yqsl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zgjt.yqsl.entity.StoreResporty;

import java.util.List;
import java.util.Map;

public interface TradeResportyMapper extends BaseMapper<StoreResporty> {

    int insertBatch(String shopId, List<StoreResporty> list);

    List<Map<String,Object>> gapTradeEnter(String tradeNo);

}
