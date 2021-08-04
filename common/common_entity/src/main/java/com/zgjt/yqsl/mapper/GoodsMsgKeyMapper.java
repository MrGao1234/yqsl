package com.zgjt.yqsl.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zgjt.yqsl.entity.GoodsMsgKey;

import java.util.List;

/**
 * @author admin
 */
public interface GoodsMsgKeyMapper extends BaseMapper<GoodsMsgKey> {

    /**
     * 插入属性
     *
     * @param list 属性列表
     * @return int 插入了几条
     */
    int insertGoodsMsgKey(List<GoodsMsgKey> list);

}
