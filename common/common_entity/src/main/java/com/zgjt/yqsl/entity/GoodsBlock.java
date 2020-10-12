package com.zgjt.yqsl.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;

import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author testjava
 * @since 2020-10-12
 */
@Data
public class GoodsBlock implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer goodsId;

    private Integer num;

    private Integer surplusNum;

    private Date produceDate;

    private Date orderDate;

    private Date acceptDate;

    private Integer shopId;

    private Integer orderUser;

    @Version
    private Integer version;


    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableLogic
    private Integer isDeleted;


}
