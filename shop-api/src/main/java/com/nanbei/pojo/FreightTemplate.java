package com.nanbei.pojo;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 对应数据库表 tb_freight_template。
 */
@Data
public class FreightTemplate {

    private Long id;

    // 商家ID
    private String sellerId;

    // 是否默认   （‘Y’是   'N'否）
    private String isDefault;

    // 模版名称
    private String name;

    // 发货时间（1:12h  2:24h  3:48h  4:72h  5:7d 6:15d ）
    private String sendTimeType;

    // 统一价格
    private BigDecimal price;

    // 创建时间
    private LocalDateTime createTime;
}
