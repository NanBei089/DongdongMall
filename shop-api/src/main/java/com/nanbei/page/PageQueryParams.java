package com.nanbei.page;

import lombok.Data;

/**
 * 分页查询参数。
 * @param <T> 查询参数类型
 *
 */
@Data
public class PageQueryParams<T> {

    private int pageNum=1;// 当前页码

    private int pageSize=10;// 每页大小

    private T params;// 查询参数
}
