package com.zgjt.yqsl.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("goods_msg")
@JsonInclude(value= JsonInclude.Include.NON_NULL)
public class GoodsMsg implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer brandId;

    private Integer typeId;

    private String unit;

    private String spec;

    private String specUnit;

    private BigDecimal price;

    private String avartal;

    private Integer qualityDate;

    private String qualityUnit;

    private String message;

    private String status;

    @TableLogic
    private Integer isDeleted;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(exist = false)
    private GoodsBrand goodsBrand;

    @TableField(exist = false)
    private GoodsType goodsType;

}
