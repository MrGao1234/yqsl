package com.zgjt.yqsl.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zgjt.yqsl.entity.GoodsMsg;
import com.zgjt.yqsl.mapper.GoodsMsgMapper;
import com.zgjt.yqsl.mapper.GoodsTypeMapper;
import com.zgjt.yqsl.service.GoodsMsgService;
import com.zgjt.yqsl.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class GoodsMsgServiceImpl extends ServiceImpl<GoodsMsgMapper,GoodsMsg> implements GoodsMsgService {

    @Autowired
    private GoodsMsgMapper goodsMsgMapper;

    @Autowired
    private GoodsTypeMapper goodsTypeMapper;

    //查询商品列表
    public IPage<GoodsMsg> findGoodsMsg(@RequestBody PageVo pageVo){

        IPage<GoodsMsg> page = new Page<>(pageVo.getPageNumber(),pageVo.getPageSize());
        page.setRecords(goodsMsgMapper.findGoods(pageVo,page));
        return page;
    }
}
