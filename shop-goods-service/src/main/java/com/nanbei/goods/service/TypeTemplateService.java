package com.nanbei.goods.service;

import com.nanbei.page.PageList;
import com.nanbei.page.PageQueryParams;
import com.nanbei.pojo.TypeTemplate;
import com.nanbei.vo.TypeTemplateVo;

public interface TypeTemplateService {

    /**
     * 分页查询
     * @param params 分页参数
     * @return 分页结果
     */
    PageList<TypeTemplateVo> queryByPage(PageQueryParams<TypeTemplate> params);



}
