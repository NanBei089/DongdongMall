package com.nanbei.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 对应数据库表 tb_brand。
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Brand {

    private Long id;

    // 品牌名称
    private String name;

    // 品牌首字母
    private String firstChar;
}
