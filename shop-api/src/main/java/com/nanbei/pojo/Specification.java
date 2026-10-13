package com.nanbei.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 规格表
 * @TableName tb_specification
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Specification {
    /**
     * 主键
     */
    private Long id;

    /**
     * 名称
     */
    private String specName;
}