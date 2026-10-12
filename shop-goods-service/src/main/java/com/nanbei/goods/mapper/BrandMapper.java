package com.nanbei.goods.mapper;

import com.nanbei.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapper {

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
    Brand selectBrandById(Long id);

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
    void deleteBatchBrand(@Param("ids") List<Long> ids);

    /**
     * 分页查询品牌，条件为空时查询全部。
     */
    List<Brand> selectBrandByPage(@Param("brand") Brand brand);
}
