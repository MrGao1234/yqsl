package com.zgjt.yqsl.service;

import com.zgjt.yqsl.entity.GoodsType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author testjava
 * @since 2020-10-12
 */
public interface GoodsTypeService extends IService<GoodsType> {
    List<GoodsType> goodsTypeList();
}
