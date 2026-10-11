package com.nanbei.pojo;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 对应数据库表 tb_seckill_order。
 */
@Data
public class SeckillOrder {

    // 主键
    private Long id;

    // 秒杀商品ID
    private Long seckillId;

    // 支付金额
    private BigDecimal money;

    // 用户
    private String userId;

    // 商家
    private String sellerId;

    // 创建时间
    private LocalDateTime createTime;

    // 支付时间
    private LocalDateTime payTime;

    // 状态
    private String status;

    // 收货人地址
    private String receiverAddress;

    // 收货人电话
    private String receiverMobile;

    // 收货人
    private String receiver;

    // 交易流水
    private String transactionId;
}
