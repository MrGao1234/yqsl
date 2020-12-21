package com.zgjt.yqsl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zgjt.yqsl.entity.GoodsMsg;
import com.zgjt.yqsl.vo.PageVo;


public interface GoodsMsgService extends IService<GoodsMsg> {

    //查询商品信息
    IPage<GoodsMsg> findGoodsMsg(PageVo pageVo);
}
