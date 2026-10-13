package com.nanbei.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 规格选项表
 * @TableName tb_specification_option
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpecificationOption {
    /**
     * 规格项ID
     */
    private Long id;

    /**
     * 规格项名称
     */
    private String optionName;

    /**
     * 规格ID
     */
    private Long specId;

    /**
     * 排序值
     */
    private Integer orders;
}