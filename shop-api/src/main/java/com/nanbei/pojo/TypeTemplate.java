package com.nanbei.pojo;

import lombok.Data;

/**
 * 对应数据库表 tb_type_template。
 */
@Data
public class TypeTemplate {

    private Long id;

    // 模板名称
    private String name;

    // 关联规格
    private String specIds;

    // 关联品牌
    private String brandIds;

    // 自定义属性
    private String customAttributeItems;
}
