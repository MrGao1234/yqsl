package com.zgjt.yqsl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zgjt.yqsl.entity.TradeEnter;
import com.zgjt.yqsl.entity.TradeResporty;

import java.util.List;
import java.util.Map;

public interface TradeRecordService extends IService<TradeEnter> {

    void createEnterTrade(Map<String,Integer> map);

    IPage<TradeEnter> findTradeEnter(Map<String,Object> tradeEnter);

    int examinTrade(List<TradeResporty> list);

    List<Map<String,Object>> gapTradeEnter(String tradeNo);
}
