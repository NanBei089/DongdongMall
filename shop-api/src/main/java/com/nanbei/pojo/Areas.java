package com.nanbei.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 对应数据库表 tb_areas。
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Areas {

    // 唯一ID
    private Integer id;

    // 区域ID
    private String areaid;

    // 区域名称
    private String area;

    // 城市ID
    private String cityid;
}
