package com.nanbei.pojo;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 对应数据库表 tb_pay_log。
 */
@Data
public class PayLog {

    // 支付订单号
    private String outTradeNo;

    // 创建日期
    private LocalDateTime createTime;

    // 支付完成时间
    private LocalDateTime payTime;

    // 支付金额（分）
    private Long totalFee;

    // 用户ID
    private String userId;

    // 交易号码
    private String transactionId;

    // 交易状态
    private String tradeState;

    // 订单编号列表
    private String orderList;

    // 支付类型
    private String payType;
}
