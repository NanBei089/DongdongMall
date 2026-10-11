package com.nanbei.pojo;

import lombok.Data;

/**
 * 对应数据库表 tb_specification_option。
 */
@Data
public class SpecificationOption {

    // 规格项ID
    private Long id;

    // 规格项名称
    private String optionName;

    // 规格ID
    private Long specId;

    // 排序值
    private Integer orders;
}
