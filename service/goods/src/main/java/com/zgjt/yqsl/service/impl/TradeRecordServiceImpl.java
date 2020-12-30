package com.zgjt.yqsl.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zgjt.yqsl.component.CurrentUserComponent;
import com.zgjt.yqsl.entity.PowerUser;
import com.zgjt.yqsl.entity.TradeDetails;
import com.zgjt.yqsl.entity.TradeEnter;
import com.zgjt.yqsl.entity.TradeResporty;
import com.zgjt.yqsl.mapper.TradeDetailsMapper;
import com.zgjt.yqsl.mapper.TradeEnterMapper;
import com.zgjt.yqsl.mapper.TradeResportyMapper;
import com.zgjt.yqsl.service.TradeRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

@Slf4j
@Service
public class TradeRecordServiceImpl extends ServiceImpl<TradeEnterMapper, TradeEnter> implements TradeRecordService {

    @Autowired
    private TradeEnterMapper tradeEnterMapper;

    @Autowired
    private TradeDetailsMapper tradeDetailsMapper;

    @Autowired
    private CurrentUserComponent currentUserComponent;

    @Autowired
    private TradeResportyMapper tradeResportyMapper;

    @Override
    @Transactional
    public void createEnterTrade(Map<String, Integer> map) {

        //封装 tradeEnter
        String tradeNo = UUID.randomUUID().toString().replace("-","");
        PowerUser powerUser = currentUserComponent.findCurrentUser();
        TradeEnter tradeEnter = new TradeEnter(tradeNo,powerUser.getId(),new Date(),powerUser.getShopId(),"1");

        List<TradeDetails> list = new ArrayList();
        //details
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            list.add(new TradeDetails(tradeNo,Integer.parseInt(entry.getKey()),entry.getValue(),"0"));
        }

        int detailsNum = tradeDetailsMapper.insertList(list);
        int enterNum = tradeEnterMapper.insert(tradeEnter);

        log.info("detailsNum: {}",detailsNum);
        log.info("enterNum: {}",enterNum);

    }

    @Override
    public IPage<TradeEnter> findTradeEnter(Map<String,Object> tradeEnter) {

        IPage<TradeEnter> page = new Page((int)tradeEnter.get("pageNum"),(int)tradeEnter.get("pageSize"));

        String shopId = currentUserComponent.findCurrentUser().getShopId();
        if(shopId != null && shopId != ""){
            tradeEnter.put("shopId",shopId);
        }
        List<TradeEnter> list = tradeEnterMapper.findTradeEnterList(tradeEnter,page);
        page.setRecords(list);
        return page;
    }

    @Override
    public int examinTrade(List<TradeResporty> list) {
        PowerUser powerUser = currentUserComponent.findCurrentUser();
        return tradeResportyMapper.insertBatch(powerUser.getShopId(),list);
    }

    @Override
    public List<Map<String,Object>> gapTradeEnter(String tradeNo) {
        List<Map<String,Object>> gapMap = tradeResportyMapper.gapTradeEnter(tradeNo);
        return gapMap;
    }
}
