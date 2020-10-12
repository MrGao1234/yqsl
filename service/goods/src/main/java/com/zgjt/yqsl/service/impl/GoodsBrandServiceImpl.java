package com.zgjt.yqsl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zgjt.yqsl.entity.GoodsBrand;
import com.zgjt.yqsl.mapper.GoodsBrandMapper;
import com.zgjt.yqsl.service.GoodsBrandService;
import org.springframework.stereotype.Service;

@Service
public class GoodsBrandServiceImpl extends ServiceImpl<GoodsBrandMapper,GoodsBrand> implements GoodsBrandService {
}
