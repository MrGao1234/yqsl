package com.zgjt.yqsl.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

/**
 * @author admin
 */
@Data
@TableName("goods_msg_value")
@JsonInclude(value= JsonInclude.Include.NON_NULL)
public class GoodsMsgValue {

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;
    private String goodsMsgKeyId;
    private String value;

    @TableLogic
    private Integer isDeleted;

    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;

}
