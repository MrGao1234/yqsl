package com.zgjt.yqsl.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("power_user")
@JsonInclude(value= JsonInclude.Include.NON_NULL)
public class PowerUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String account;

    private int sex;

    private Date birthdayDate;

    private String userPwd;

    private String avatar;

    private String status;

    private String idCard;

    private int duty;

    private String shopId;

    private String telephone;

    @TableField(exist = false)
    private PowerShop powerShop;

    @TableLogic
    private Integer isDeleted;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
}
