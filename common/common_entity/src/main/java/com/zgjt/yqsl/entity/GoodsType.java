package com.zgjt.yqsl.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(value= JsonInclude.Include.NON_NULL)
public class GoodsType implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer parentId;
}
