package com.nanbei.pojo;

import lombok.Data;

/**
 * 对应数据库表 tb_content_category。
 */
@Data
public class ContentCategory {

    // 类目ID
    private Long id;

    // 分类名称
    private String name;
}
