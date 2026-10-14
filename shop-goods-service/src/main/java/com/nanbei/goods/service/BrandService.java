package com.nanbei.goods.service;

import com.nanbei.page.PageList;
import com.nanbei.page.PageQueryParams;
import com.nanbei.pojo.Brand;
import com.nanbei.vo.BrandVo;

import java.util.List;

public interface BrandService {

    /**
     * 添加品牌
     */
    void insertBrand(Brand brand);

    /**
     * 修改品牌
     */
    void updateBrand(Brand brand);

    /**
     * 删除品牌
     */
    void deleteBrand(Long id);

    /**
     * 批量删除品牌
     */
    void deleteBatchBrand(List<Long> ids);

    /**
     * 分页查询
     */
    PageList<BrandVo> selectBrandByPage(PageQueryParams<Brand> params);


}
