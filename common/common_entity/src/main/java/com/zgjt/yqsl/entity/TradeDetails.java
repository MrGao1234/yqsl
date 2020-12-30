package com.zgjt.yqsl.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("trade_details")
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value= JsonInclude.Include.NON_NULL)
public class TradeDetails {

    @TableId(type = IdType.AUTO)
    private int id;
    private String tradeNo;
    private int goodsId;
    @TableField(exist = false)
    private GoodsMsg goodsMsg;

    private int num;
    private String status;

    public TradeDetails(String tradeNo,int goodsId,int num,String status){
        this.tradeNo = tradeNo;
        this.goodsId = goodsId;
        this.num = num;
        this.status = status;
    }

}
