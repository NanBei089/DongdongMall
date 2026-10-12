package com.nanbei.goods.service.Ipml;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nanbei.goods.mapper.BrandMapper;
import com.nanbei.goods.service.BrandService;
import com.nanbei.page.PageList;
import com.nanbei.page.PageQueryParams;
import com.nanbei.pojo.Brand;
import com.nanbei.vo.BrandVo;
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
     * 使用pagehelper
     * 1.设置分页参数
     * 2.查询分页数据
     * 3.获取总条数
     * 4.返回PageList
     * @param params
     */
    @Override
    public PageList<BrandVo> selectBrandByPage(PageQueryParams<Brand> params) {
        //1.设置分页参数
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        //2.查询分页数据
        List<Brand> list = brandMapper.selectBrandByPage(params.getParams());
        List<BrandVo> brandRows = list.stream().map(brand ->
                new BrandVo(brand.getBrandId(),
                        brand.getBrandName(),
                        brand.getBrandFirstChar()
                )
        ).toList();

        //3.获取总条数
        PageInfo<BrandVo> pageInfo = new PageInfo<>(brandRows);
        //4.返回PageList
        return new PageList<>(pageInfo.getTotal(), brandRows);
    }
}
