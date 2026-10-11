package com.nanbei.pojo;

import lombok.Data;

/**
 * 对应数据库表 tb_item_cat。
 */
@Data
public class ItemCat {

    // 类目ID
    private Long id;

    // 父类目ID=0时，代表的是一级的类目
    private Long parentId;

    // 类目名称
    private String name;

    // 类型id
    private Long typeId;
}
