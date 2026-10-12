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
     * 查询所有品牌
     */
    List<Brand> selectAllBrand();

    /**
     * 根据品牌id查询品牌
     */
    Brand selectBrandById(int id);

    /**
     * 修改品牌
     */
    void updateBrand(Brand brand);

    /**
     * 删除品牌
     */
    void deleteBrand(int id);

    /**
     * 批量删除品牌
     */
    void deleteBatchBrand(List<Long> ids);

    /**
     * 分页查询
     */
    PageList<BrandVo> selectBrandByPage(PageQueryParams<Brand> params);


}
