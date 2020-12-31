package com.zgjt.yqsl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zgjt.yqsl.entity.TradeDetails;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TradeDetailsMapper extends BaseMapper<TradeDetails> {
    int insertList(@Param("list") List<TradeDetails> list);
}
