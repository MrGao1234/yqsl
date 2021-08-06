package com.zgjt.yqsl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zgjt.yqsl.entity.GoodsMsg;
import com.zgjt.yqsl.entity.GoodsMsgKey;
import com.zgjt.yqsl.vo.PageVo;

import java.util.List;


public interface GoodsMsgService extends IService<GoodsMsg> {

    /**
     * 查询商品信息
     */
    IPage<GoodsMsg> findGoodsMsg(PageVo pageVo);

    /**
     * 查询商品属性
     * */
    List<GoodsMsgKey> findGoodsAttributes(int goodsId);

    /**
     * 保存商品信息
     * */
    boolean saveGoodsMsg(GoodsMsg goodsMsg);
}
