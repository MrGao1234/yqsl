package com.zgjt.yqsl.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("goods_msg")
public class GoodsMsg implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer brandId;

    private Integer typeId;

    private String unit;

    private BigDecimal price;

    private String avartal;

    private Integer qualityDate;

    private String qualityUnit;

    @TableLogic
    private Integer isDeleted;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date update_time;

    @TableField(fill = FieldFill.INSERT)
    private Date create_time;
}
