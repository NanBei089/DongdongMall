package com.nanbei.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 商品类目
 * @TableName tb_item_cat
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ItemCat {
    /**
     * 类目ID
     */
    private Long id;

    /**
     * 父类目ID=0时，代表的是一级的类目
     */
    private Long parentId;

    /**
     * 类目名称
     */
    private String name;

    /**
     * 类型id
     */
    private Long typeId;
}