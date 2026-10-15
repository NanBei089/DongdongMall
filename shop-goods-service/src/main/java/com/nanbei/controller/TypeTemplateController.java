package com.nanbei.controller;

import com.nanbei.dto.TypeTemplateDto;
import com.nanbei.service.TypeTemplateService;
import com.nanbei.page.PageList;
import com.nanbei.page.PageQueryParams;
import com.nanbei.pojo.TypeTemplate;
import com.nanbei.result.Result;
import com.nanbei.vo.TypeTemplateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/typeTemplate")
public class TypeTemplateController {
    @Autowired
    private TypeTemplateService typeTemplateService;

    /**
     * 分页查询
     * @param params 分页参数
     * @return 分页结果
     */
    @PostMapping("/queryByPage")
    public Result<PageList<TypeTemplateVo>> queryByPage(@RequestBody PageQueryParams<TypeTemplate> params) {
        PageList<TypeTemplateVo> page = typeTemplateService.queryByPage(params);
        return Result.success(page);
    }

    /**
     * 删除类型模板
     * @param ids 删除的ID列表
     * @return 删除结果
     */
    @DeleteMapping("/delete")
    public Result delete(@RequestBody List<Long> ids) {
        typeTemplateService.delete(ids);
        return Result.success();
    }

    /**
     * 保存
     * @param typeTemplateDto 类型模板
     * @return 保存结果
     */
    @PostMapping("/save")
    public Result save(@RequestBody TypeTemplateDto typeTemplateDto) {
        if (typeTemplateDto.getId() == null) {
            // 添加
            typeTemplateService.add(typeTemplateDto);
        } else {
            typeTemplateService.update(typeTemplateDto);
        }
        return Result.success();
    }
}
