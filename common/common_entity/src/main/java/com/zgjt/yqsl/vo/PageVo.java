package com.zgjt.yqsl.vo;

import lombok.Data;

@Data
public class PageVo {
    private String name;
    private int pageNumber;
    private int pageSize;
    private int brandId;
    private int typeId;
}
