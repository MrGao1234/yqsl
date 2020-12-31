package com.zgjt.yqsl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zgjt.yqsl.entity.TradeEnter;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TradeEnterMapper extends BaseMapper<TradeEnter> {

    List<TradeEnter> findTradeEnterList(@Param("tradeEnter") Map<String, Object> tradeEnter, IPage page);
}
