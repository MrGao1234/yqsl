package com.zgjt.yqsl.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author admin
 */
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

    private String avartal;

    private String message;

    private String status;

    private List<GoodsMsgKey> attributes;

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
