package com.zgjt.yqsl.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
@TableName("trade_resporty")
@JsonInclude(value= JsonInclude.Include.NON_NULL)
public class TradeResporty {

    @TableId(type = IdType.AUTO)
    private int id;

    private String shopId;
    private int goodsId;

    @TableField(exist = false)
    private GoodsMsg goodsMsg;

    private Date productDate;
    private int num;

    private String tradeNo;

}
