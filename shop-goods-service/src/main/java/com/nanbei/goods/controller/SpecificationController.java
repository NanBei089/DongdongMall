package com.nanbei.goods.controller;

import com.nanbei.goods.service.SpecificationService;
import com.nanbei.page.PageList;
import com.nanbei.page.PageQueryParams;
import com.nanbei.pojo.SpecAndOption;
import com.nanbei.result.Result;
import com.nanbei.vo.SpecAndOptionVo;
import com.nanbei.vo.SpecificationVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/specification")
@Tag(name = "规格管理", description = "规格查询与维护接口")
public class SpecificationController {
    @Autowired
    private SpecificationService specificationService;

    /**
     * 分页查询规格列表
     */
    @PostMapping("/queryPage")
    @Operation(summary = "分页查询规格列表")
    public Result<PageList<SpecificationVo>> queryPage(@RequestBody PageQueryParams<SpecificationVo> params) {
        PageList<SpecificationVo> specPageList = specificationService.selectSpecificationList(params);
        return Result.success(specPageList);
    }

    /**
     * 删除规格
     */
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "删除规格")
    public Result<Void> delete(@PathVariable("id") Long id) {
        specificationService.deleteSpecification(id);
        return Result.success();
    }

    /**
     * 批量删除规格
     * @param ids
     */
    @DeleteMapping("/deleteBatch")
    @Operation(summary = "批量删除规格")
    public Result<Void> deleteBatch(@RequestBody List<Long> ids) {
        specificationService.deleteBatchSpecification(ids);
        return Result.success();
    }

    /**
     * 添加规格
     * @param record
     */

    @PostMapping("/add")
    @Operation(summary = "添加规格")
    public Result<Void> add(@RequestBody SpecAndOption record) {
        specificationService.insertSpecification(record);
        return Result.success();
    }

    /**
     * 修改规格
     * @param record
     */
    @PostMapping("/update")
    @Operation(summary = "修改规格")
    public Result<Void> update(@RequestBody SpecAndOption record) {
        specificationService.updateSpecification(record);
        return Result.success();
    }

    /**
     * 回显数据
     * @param id
     * @return
     */
    @GetMapping("/detail/{id}")
    @Operation(summary = "回显数据")
    public Result<SpecAndOptionVo> detail(@PathVariable("id") Long id) {
        SpecAndOptionVo detail = specificationService.selectByPrimaryKey(id);
        return Result.success(detail);
    }
}
