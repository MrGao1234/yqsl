package com.zgjt.yqsl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zgjt.yqsl.entity.GoodsMsg;
import com.zgjt.yqsl.entity.GoodsMsgKey;
import com.zgjt.yqsl.vo.PageVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author admin
 */
public interface GoodsMsgMapper extends BaseMapper<GoodsMsg> {

    /**
     * 获取商品基本信息列表
     *
     * @param pageVo 页面
     * @param page page number
     * @return List<GoodsMsg>
     */
    List<GoodsMsg> findGoods(@Param("pageVo") PageVo pageVo, IPage<GoodsMsg> page);

    /**
     * 获取商品属性列表
     *
     * @param goodsId 商品主键
     * @return List<GoodsMsgKey>
     */
    List<GoodsMsgKey> findAttributesByGoodsId(int goodsId);

}
