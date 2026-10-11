package com.nanbei.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 对应数据库表 tb_cities。
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cities {

    // 唯一ID
    private Integer id;

    // 城市ID
    private String cityid;

    // 城市名称
    private String city;

    // 省份ID
    private String provinceid;
}
