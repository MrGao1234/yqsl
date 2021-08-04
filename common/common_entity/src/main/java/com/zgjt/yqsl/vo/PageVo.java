package com.zgjt.yqsl.vo;

import lombok.Data;

@Data
public class PageVo {
    private String name;
    private Integer pageNumber;
    private Integer pageSize;
    private Integer brandId;
    private Integer typeId;

    private String sex;
    private String duty;
    private String status;
}
