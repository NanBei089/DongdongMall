package com.nanbei.pojo;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 对应数据库表 tb_seckill_goods。
 */
@Data
public class SeckillGoods {

    private Long id;

    // spu ID
    private Long goodsId;

    // sku ID
    private Long itemId;

    // 标题
    private String title;

    // 商品图片
    private String smallPic;

    // 原价格
    private BigDecimal price;

    // 秒杀价格
    private BigDecimal costPrice;

    // 商家ID
    private String sellerId;

    // 添加日期
    private LocalDateTime createTime;

    // 审核日期
    private LocalDateTime checkTime;

    // 审核状态
    private String status;

    // 开始时间
    private LocalDateTime startTime;

    // 结束时间
    private LocalDateTime endTime;

    // 秒杀商品数
    private Integer num;

    // 剩余库存数
    private Integer stockCount;

    // 描述
    private String introduction;
}
