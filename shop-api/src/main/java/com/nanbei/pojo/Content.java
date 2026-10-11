package com.nanbei.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 对应数据库表 tb_content。
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Content {

    private Long id;

    // 内容类目ID
    private Long categoryId;

    // 内容标题
    private String title;

    // 链接
    private String url;

    // 图片绝对路径
    private String pic;

    // 状态
    private String status;

    // 排序
    private Integer sortOrder;
}
