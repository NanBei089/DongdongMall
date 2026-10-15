package com.nanbei.service;

import com.nanbei.dto.TypeTemplateDto;
import com.nanbei.page.PageList;
import com.nanbei.page.PageQueryParams;
import com.nanbei.pojo.TypeTemplate;
import com.nanbei.vo.TypeTemplateVo;

import java.util.List;

public interface TypeTemplateService {

    /**
     * 分页查询
     * @param params 分页参数
     * @return 分页结果
     */
    PageList<TypeTemplateVo> queryByPage(PageQueryParams<TypeTemplate> params);

    /**
     * 删除
     */
    void delete(List<Long> ids);

    /**
     * 添加
     */
    void add(TypeTemplateDto typeTemplateDto);

    /**
     * 修改
     */
    void update(TypeTemplateDto typeTemplateDto);

}
