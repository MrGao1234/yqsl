package com.zgjt.yqsl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zgjt.yqsl.entity.GoodsType;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2020-10-12
 */
public interface GoodsTypeMapper extends BaseMapper<GoodsType> {

    /**
     * 获取商品分类列表，自连接
     * @return List<GoodsType>
     */
    List<GoodsType> findGoodsType();
}
