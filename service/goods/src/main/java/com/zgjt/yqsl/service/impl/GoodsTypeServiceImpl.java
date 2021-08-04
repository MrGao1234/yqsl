package com.zgjt.yqsl.service.impl;

import com.zgjt.yqsl.entity.GoodsType;
import com.zgjt.yqsl.mapper.GoodsTypeMapper;
import com.zgjt.yqsl.service.GoodsTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-10-12
 */
@Service
public class GoodsTypeServiceImpl extends ServiceImpl<GoodsTypeMapper, GoodsType> implements GoodsTypeService {

    @Autowired
    private GoodsTypeMapper goodsTypeMapper;

    @Override
    public List<GoodsType> goodsTypeList(){
        return goodsTypeMapper.findGoodsType();
    }
}
