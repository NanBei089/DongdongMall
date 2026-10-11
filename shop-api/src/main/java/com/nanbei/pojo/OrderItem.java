package com.nanbei.pojo;

import lombok.Data;
import java.math.BigDecimal;

/**
 * 对应数据库表 tb_order_item。
 */
@Data
public class OrderItem {

    private Long id;

    // 商品id
    private Long itemId;

    // SPU_ID
    private Long goodsId;

    // 订单id
    private Long orderId;

    // 商品标题
    private String title;

    // 商品单价
    private BigDecimal price;

    // 商品购买数量
    private Integer num;

    // 商品总金额
    private BigDecimal totalFee;

    // 商品图片地址
    private String picPath;

    private String sellerId;
}
