package com.nanbei.page;

import lombok.Data;

/**
 * 分页查询参数。
 */
@Data
public class PageQuery {

    private int pageNum;

    private int pageSize;
}
