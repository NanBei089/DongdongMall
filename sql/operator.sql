-- 运营商表
CREATE TABLE tb_operator
(
    operator_id     VARCHAR(100) NOT NULL COMMENT '运营商ID'
        PRIMARY KEY,

    username        VARCHAR(50)  NOT NULL COMMENT '登录账号',
    password        VARCHAR(60)  NOT NULL COMMENT '登录密码',
    salt            VARCHAR(60)  NULL COMMENT '密码盐',

    name            VARCHAR(80)  NULL COMMENT '运营商姓名',
    nick_name       VARCHAR(50)  NULL COMMENT '运营商昵称',

    email           VARCHAR(40)  NULL COMMENT '电子邮箱',
    mobile          VARCHAR(11)  NULL COMMENT '手机号码',
    telephone       VARCHAR(50)  NULL COMMENT '联系电话',

    status          VARCHAR(1) DEFAULT '1' COMMENT '状态：0禁用，1正常，2锁定',

    role            VARCHAR(30)  NULL COMMENT '角色：admin管理员，operator普通运营人员',

    address_detail  VARCHAR(100) NULL COMMENT '详细地址',
    avatar          VARCHAR(255) NULL COMMENT '头像地址',

    create_time     DATETIME   DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time     DATETIME   DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    last_login_time DATETIME     NULL COMMENT '最后登录时间',

    remark          VARCHAR(500) NULL COMMENT '备注',

    UNIQUE KEY uk_username (username)
)
    COMMENT '运营商表'
    CHARSET = utf8mb4;


# 密码：123456
# 加密方式：BCrypt
INSERT INTO tb_operator
(operator_id, username, password, salt, name, nick_name,
 email, mobile, status, role, create_time, remark)
VALUES ('OP001', 'admin',
        '$2y$10$mnQ2tQJechet59Xae6pl2uezScXiFz69HavMMsw1QySa66PrQ6xA2',
        NULL, '张伟', '超级管理员',
        'admin@example.com', '13800000001', '1', 'admin',
        '2026-01-10 09:00:00', '商城平台超级管理员'),

       ('OP002', 'operator01',
        '$2y$10$mnQ2tQJechet59Xae6pl2uezScXiFz69HavMMsw1QySa66PrQ6xA2',
        NULL, '李娜', '运营主管',
        'operator01@example.com', '13800000002', '1', 'operator',
        '2026-02-15 10:30:00', '负责商城日常运营管理'),

       ('OP003', 'operator02',
        '$2y$10$mnQ2tQJechet59Xae6pl2uezScXiFz69HavMMsw1QySa66PrQ6xA2',
        NULL, '王强', '商品审核员',
        'operator02@example.com', '13800000003', '1', 'operator',
        '2026-03-20 14:20:00', '负责商品上架审核'),

       ('OP004', 'operator03',
        '$2y$10$mnQ2tQJechet59Xae6pl2uezScXiFz69HavMMsw1QySa66PrQ6xA2',
        NULL, '赵敏', '商家审核员',
        'operator03@example.com', '13800000004', '1', 'operator',
        '2026-04-12 11:15:00', '负责商家入驻审核'),

       ('OP005', 'operator04',
        '$2y$10$mnQ2tQJechet59Xae6pl2uezScXiFz69HavMMsw1QySa66PrQ6xA2',
        NULL, '刘洋', '运营专员',
        'operator04@example.com', '13800000005', '0', 'operator',
        '2026-05-18 16:40:00', '账号已禁用'),

       ('OP006', 'operator05',
        '$2y$10$mnQ2tQJechet59Xae6pl2uezScXiFz69HavMMsw1QySa66PrQ6xA2',
        NULL, '陈晨', '客服管理员',
        'operator05@example.com', '13800000006', '2', 'operator',
        '2026-06-22 08:45:00', '账号已锁定');