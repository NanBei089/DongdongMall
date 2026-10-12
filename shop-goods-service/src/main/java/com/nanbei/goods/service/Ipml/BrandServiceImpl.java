package com.nanbei.goods.service.Ipml;

import com.nanbei.goods.mapper.BrandMapper;
import com.nanbei.goods.service.BrandService;
import com.nanbei.pojo.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    /**
     * 添加品牌
     *
     * @param brand
     */
    @Override
    public void insertBrand(Brand brand) {
        brandMapper.insertBrand(brand);
    }

    /**
     * 查询所有品牌
     */
    @Override
    public List<Brand> selectAllBrand() {
        return brandMapper.selectAllBrand();
    }

    /**
     * 根据品牌id查询品牌
     *
     * @param id
     */
    @Override
    public Brand selectBrandById(int id) {
        return brandMapper.selectBrandById(id);
    }

    /**
     * 修改品牌
     *
     * @param brand
     */
    @Override
    public void updateBrand(Brand brand) {
        brandMapper.updateBrand(brand);
    }

    /**
     * 删除品牌
     *
     * @param id
     */
    @Override
    public void deleteBrand(int id) {
        brandMapper.deleteBrand(id);
    }

    /**
     * 批量删除品牌
     *
     * @param ids
     */
    @Override
    public void deleteBatchBrand(List<Long> ids) {
        brandMapper.deleteBatchBrand(ids);
    }

    /**
     * 分页查询
     *
     * @param pageNum
     * @param pageSize
     */
    @Override
    public List<Brand> selectBrandByPage(int pageNum, int pageSize) {
        return List.of();
    }
}
