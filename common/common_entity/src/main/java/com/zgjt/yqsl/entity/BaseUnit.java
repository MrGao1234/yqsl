package com.zgjt.yqsl.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("base_unit")
public class BaseUnit {
    private int id;
    private String name;
    private String value;
    private String type;
}
