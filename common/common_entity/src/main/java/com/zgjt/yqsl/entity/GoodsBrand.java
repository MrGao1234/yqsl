package com.zgjt.yqsl.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("goods_brand")
@JsonInclude(value= JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value={"isDeleted","updateTime","createTime"})
public class GoodsBrand implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String avatar;

    private String message;

    @TableLogic
    private Integer isDeleted;

    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;
}
