package com.nanbei.controller;

import com.nanbei.page.PageList;
import com.nanbei.page.PageQueryParams;
import com.nanbei.pojo.Department;
import com.nanbei.result.Result;
import com.nanbei.service.DepartmentService;
import com.nanbei.vo.DepartmentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    /**
     * 查询所有
     */
    @PostMapping("/queryAll")
    public Result<List<DepartmentVo>> queryAll() {
        return Result.success(departmentService.queryAll());
    }

    /**
     * 添加
     */
    @PostMapping("/add")
    public Result add(@RequestBody Department department) {
        departmentService.add(department);
        return Result.success();
    }
    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody Department department) {
        departmentService.update(department);
        return Result.success();
    }
    /**
     * 删除
     */
    @PostMapping("/delete")
    public Result delete(@RequestBody List<Long> ids) {
        departmentService.delete(ids);
        return Result.success();
    }
}
