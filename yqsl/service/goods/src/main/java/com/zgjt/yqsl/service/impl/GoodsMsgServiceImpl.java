package com.zgjt.yqsl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zgjt.yqsl.entity.GoodsMsg;
import com.zgjt.yqsl.mapper.GoodsMsgMapper;
import com.zgjt.yqsl.service.GoodsMsgService;
import org.springframework.stereotype.Service;

@Service
public class GoodsMsgServiceImpl extends ServiceImpl<GoodsMsgMapper,GoodsMsg> implements GoodsMsgService {
}
