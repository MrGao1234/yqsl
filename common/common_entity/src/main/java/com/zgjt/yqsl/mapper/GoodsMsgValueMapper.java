package com.zgjt.yqsl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zgjt.yqsl.entity.GoodsMsgValue;

import java.util.List;

/**
 * @author admin
 */
public interface GoodsMsgValueMapper extends BaseMapper<GoodsMsgValue> {

    /**
     * 插入属性值
     *
     * @param list 属性列表
     * @return int 插入了几条
     */
    int insertGoodsMsgValue(List<GoodsMsgValue> list);
}
