package com.zgjt.yqsl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zgjt.yqsl.entity.GoodsMsg;
import com.zgjt.yqsl.vo.PageVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMsgMapper extends BaseMapper<GoodsMsg> {

    //查询所有商品
    List<GoodsMsg> findGoods(@Param("pageVo") PageVo pageVo, IPage<GoodsMsg> page);

}
