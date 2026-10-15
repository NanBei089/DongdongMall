package com.nanbei.controller;

import com.nanbei.service.BrandService;
import com.nanbei.page.PageList;
import com.nanbei.page.PageQueryParams;
import com.nanbei.pojo.Brand;
import com.nanbei.result.Result;
import com.nanbei.vo.BrandVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/brand")
@Tag(name = "品牌管理", description = "品牌查询与维护接口")
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 分页查询品牌列表
     * @param params 分页参数
     * @return 品牌列表
     */

    @Operation(summary = "分页查询品牌列表")
    @PostMapping("/queryPage")
    public Result<PageList<BrandVo>> queryPage(@RequestBody PageQueryParams<Brand> params) {
        PageList<BrandVo> brandVoPageList = brandService.selectBrandByPage(params);
        return Result.success(brandVoPageList);
    }

    /**
     * 添加品牌
     * @param brand 品牌对象
     * @return 结果
     */

    @Operation(summary = "添加品牌")
    @PostMapping("/add")
    public Result add(@RequestBody Brand brand) {
        brandService.insertBrand(brand);
        return Result.success();
    }

    /**
     * 修改品牌
     * @param brand 品牌对象
     * @return 结果
     */

    @Operation(summary = "修改品牌")
    @PostMapping("/update")
    public Result update(@RequestBody Brand brand) {
        brandService.updateBrand(brand);
        return Result.success();
    }

    /**
     * 删除品牌
     * @param id 品牌ID
     * @return 结果
     */
    @Operation(summary = "删除品牌")
    @DeleteMapping("/delete/{id}")
    public Result delete(@Parameter(description = "品牌 ID") @PathVariable("id") Long id) {
        brandService.deleteBrand(id);
        return Result.success();
    }

    /**
     * 批量删除品牌
     * @param ids 品牌ID数组
     * @return 结果
     */
    @Operation(summary = "批量删除品牌")
    @DeleteMapping("/deleteBatch")
    public Result deleteBatch(@RequestBody List<Long> ids) {
        brandService.deleteBatchBrand(ids);
        return Result.success();
    }

    @Operation(summary = "查询所有品牌")
    @GetMapping("/queryAll")
    public Result<List<BrandVo>> queryAll() {
        List<BrandVo> brandList = brandService.queryAll();
        return Result.success(brandList);
    }
}
