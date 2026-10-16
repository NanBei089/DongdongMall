package com.nanbei.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 模板表
 * @TableName tb_type_template
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeTemplateVo {
    /**
     * 模板id
     */
    private Long id;

    /**
     * 模板名称
     */
    private String name;

    /**
     * 关联规格
     */
    private String specIds;

    /**
     * 关联品牌
     */
    private String brandIds;

    /**
     * 自定义属性
     */
    private String customAttributeItems;
}