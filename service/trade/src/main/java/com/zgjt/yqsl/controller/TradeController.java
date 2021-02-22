package com.zgjt.yqsl.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zgjt.yqsl.annotation.AuthorityAnnotation;
import com.zgjt.yqsl.entity.TradeEnter;
import com.zgjt.yqsl.entity.StoreResporty;
import com.zgjt.yqsl.response.ResponseApi;
import com.zgjt.yqsl.service.TradeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/trade")
public class TradeController {

    @Autowired
    private TradeRecordService tradeRecordService;

    @AuthorityAnnotation(value = {2})
    @PostMapping("/saveTrade")
    public ResponseApi createTrade( @RequestBody Map<String,Integer> tradeMap ){
       tradeRecordService.createEnterTrade(tradeMap);
       return ResponseApi.sucess();
    }

    @PostMapping("/findTrade")
    public ResponseApi findTrade(@RequestBody Map<String,Object> tradeEnterMap){
        IPage<TradeEnter> list = tradeRecordService.findTradeEnter(tradeEnterMap);
        return ResponseApi.sucess().put(list);
    }

    @PostMapping("/updateStatusTrade")
    public ResponseApi updateStatusTrade(@RequestBody TradeEnter tradeEnter){
        if(tradeEnter.getStatus().equals("6")){
            tradeEnter.setTradeGetTime(new Date());
        }
        tradeRecordService.updateById(tradeEnter);
        return ResponseApi.sucess();
    }

    @PostMapping("/examineTrade")
    public ResponseApi examinTrade(@RequestBody List<StoreResporty> tradeResportyList){
        tradeRecordService.examinTrade(tradeResportyList);
        return ResponseApi.sucess();
    }

    @PostMapping("/gapTradeEnter")
    public ResponseApi gapTradeEnter(String tradeNo){
        return ResponseApi.sucess().put(tradeRecordService.gapTradeEnter(tradeNo));
    }
}
