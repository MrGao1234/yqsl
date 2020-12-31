package com.zgjt.yqsl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zgjt.yqsl.entity.TradeResporty;

import java.util.List;
import java.util.Map;

public interface TradeResportyMapper extends BaseMapper<TradeResporty> {

    int insertBatch(String shopId, List<TradeResporty> list);

    List<Map<String,Object>> gapTradeEnter(String tradeNo);

}
