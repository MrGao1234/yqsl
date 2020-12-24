package com.zgjt.yqsl.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("power_shop")
public class PowerShop implements Serializable {

    private String id;

    private String name;

    private String address;

    private Date registerTime;

    @TableLogic
    private int isDeleted;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(exist = false)
    private PowerUser director;

    @TableField(exist = false)
    private List<PowerUser> clerkList;

    @TableField(exist = false)
    private List<String> baseImgList;
}
