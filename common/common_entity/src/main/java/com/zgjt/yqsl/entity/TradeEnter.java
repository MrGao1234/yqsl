package com.zgjt.yqsl.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("trade_enter")
@JsonInclude(value= JsonInclude.Include.NON_NULL)
public class TradeEnter {

    @TableId(type = IdType.AUTO)
    private int id;
    private String tradeNo;
    private int userId;

    @TableField(exist = false)
    private PowerUser powerUser;

    private Date tradeTime;
    private Date tradeGetTime;

    private String shopId;
    @TableField(exist = false)
    private PowerShop powerShop;

    private String status;

    @TableField(exist = false)
    private List<TradeDetails> tradeDetailsList;

    public TradeEnter(String tradeNo,int userId,Date tradeTime,String shopId,String status){
        this.tradeNo = tradeNo;
        this.userId = userId;
        this.tradeTime = tradeTime;
        this.shopId = shopId;
        this.status = status;
    }
}
