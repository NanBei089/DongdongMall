package com.nanbei.service;

import com.nanbei.page.PageList;
import com.nanbei.page.PageQueryParams;
import com.nanbei.pojo.Department;
import com.nanbei.vo.DepartmentVo;

import java.util.List;

public interface DepartmentService {

    /**
     * 按一级部门分页，返回完整子树；total 为符合条件的一级部门数量。
     */
    List<DepartmentVo> queryAll();

    /**
     * 修改
     */
    void update(Department department);

    /**
     * 添加
     */
    void add(Department department);

    /**
     * 删除
     * 删除上级部门自动选择删除上级部门所包含的下级所有部门
     */
    void delete(List<Long> ids);

}
