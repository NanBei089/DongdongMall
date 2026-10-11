package com.nanbei.pojo;

import lombok.Data;

/**
 * 对应数据库表 tb_specification。
 */
@Data
public class Specification {

    // 主键
    private Long id;

    // 名称
    private String specName;
}
