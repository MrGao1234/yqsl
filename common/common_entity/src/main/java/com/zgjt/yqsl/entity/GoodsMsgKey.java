package com.zgjt.yqsl.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author admin
 */
@Data
@TableName("goods_msg_key")
@JsonInclude(value= JsonInclude.Include.NON_NULL)
public class GoodsMsgKey {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer GoodsMsgId;
    private String name;

    private List<GoodsMsgValue> valueList;

    @TableLogic
    private Integer isDeleted;

    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;

}
