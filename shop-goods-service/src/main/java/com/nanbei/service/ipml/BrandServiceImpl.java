package com.nanbei.service.ipml;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nanbei.mapper.BrandMapper;
import com.nanbei.service.BrandService;
import com.nanbei.page.PageList;
import com.nanbei.page.PageQueryParams;
import com.nanbei.pojo.Brand;
import com.nanbei.vo.BrandVo;
import org.springframework.beans.BeanUtils;
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
    public void deleteBrand(Long id) {
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
     * @param params
     */
    @Override
    public PageList<BrandVo> selectBrandByPage(PageQueryParams<Brand> params) {
        //1.设置分页参数
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        //2.查询分页数据
        List<Brand> list = brandMapper.selectBrandByPage(params.getParams());
        //3.获取分页信息
        PageInfo<Brand> pageInfo = new PageInfo<>(list);
        //4.转换数据结构
        List<BrandVo> brandRows = list.stream().map(brand ->
                new BrandVo(brand.getBrandId(),
                        brand.getBrandName(),
                        brand.getBrandFirstChar()
                )
        ).toList();

        return new PageList<>(pageInfo.getTotal(), brandRows);
    }

    /**
     * 查询所有品牌
     */
    @Override
    public List<BrandVo> queryAll() {
        List<Brand> brands = brandMapper.selectAllBrand();
        return brands.stream().map(brand ->
                {
                    BrandVo brandVo = new BrandVo();
                    BeanUtils.copyProperties(brand, brandVo);
                    return brandVo;
                }
        ).toList();
    }
}
