package com.nanbei.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandVo {

    private Long brandId;

    // 品牌名称
    private String brandName;

    // 品牌首字母
    private String brandFirstChar;
}
