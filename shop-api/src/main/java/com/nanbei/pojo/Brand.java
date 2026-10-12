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
public class Brand {

    private Long brandId;

    // 品牌名称
    private String brandName;

    // 品牌首字母
    private String brandFirstChar;
}
