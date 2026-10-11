package com.nanbei.pojo;

import lombok.Data;

/**
 * 对应数据库表 tb_provinces。
 */
@Data
public class Provinces {

    // 唯一ID
    private Integer id;

    // 省份ID
    private String provinceid;

    // 省份名称
    private String province;
}
