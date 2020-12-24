package com.zgjt.yqsl.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(value= JsonInclude.Include.NON_NULL)
public class BaseImg implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private int id;
    private String message;
    private String avartal;
    private String tableName;
    private String tableRowId;
}
