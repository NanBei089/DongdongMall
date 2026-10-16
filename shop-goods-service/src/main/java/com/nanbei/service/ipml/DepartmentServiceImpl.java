package com.nanbei.service.ipml;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nanbei.mapper.DepartmentMapper;
import com.nanbei.page.PageList;
import com.nanbei.page.PageQueryParams;
import com.nanbei.pojo.Department;
import com.nanbei.service.DepartmentService;
import com.nanbei.vo.DepartmentVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;
    /**
     * 实现套娃结果
     */
    public List<DepartmentVo> getTree(List<Department> depts , Long parentId) {
        List<DepartmentVo> deptVos = depts.stream().filter(dept-> Objects.equals(dept.getParentId(), parentId))
                .map(dept->{
                    DepartmentVo deptVo = new DepartmentVo();
                    BeanUtils.copyProperties(dept, deptVo);
                    deptVo.setChildren(getTree(depts, dept.getId()));
                    return deptVo;
                }).toList();

        return deptVos;
    }

    /**
     * 查询数据
     * {[],[],[{},{}]}
     * 套娃结果
     *
     */
    @Override
    public List<DepartmentVo> queryAll() {
        //获取数据
        List<Department> list = departmentMapper.selectBySelective(null);
        //设置套娃数据
        List<DepartmentVo> listVos = getTree(list, null);
        return listVos;
    }

    /**
     * 修改
     *
     * @param department
     */
    @Override
    @Transactional
    public void update(Department department) {
        // 1. 获取原来的路径
        String oldPath = departmentMapper
                .selectByPrimaryKey(department.getId())
                .getDirPath();

        // 2. 计算新的dir_path
        if (department.getParentId() == null) {
            // 一级部门
            department.setDirPath("/" + department.getId());
        } else {
            // 查询父部门
            Department parentDept =
                    departmentMapper.selectByPrimaryKey(department.getParentId());

            // 拼接路径
            department.setDirPath(
                    parentDept.getDirPath() + "/" + department.getId()
            );
        }

        // 3. 更新当前部门
        departmentMapper.updateByPrimaryKeySelective(department);

        // 4. 更新所有后代部门的路径
        departmentMapper.updateChildrenPath(
                oldPath,
                department.getDirPath()
        );
    }

    /**
     * 添加
     * 先执行 insert()，让数据库生成部门 ID。
     * 获取新部门的 ID。
     * 根据 parentId 判断是不是一级部门。
     *计算 dirPath。
     * 将 dirPath 更新到数据库。
     *
     * @param department
     */
    @Override
    public void add(Department department) {
        // 1. 插入部门，数据库生成ID
        departmentMapper.insert(department);

        // 2. 设置dir_path
        if (department.getParentId() == null) {
            // 一级部门
            department.setDirPath("/" + department.getId());
        } else {
            // 查询父部门
            Department parentDept =
                    departmentMapper.selectByPrimaryKey(department.getParentId());

            // 拼接路径
            department.setDirPath(
                    parentDept.getDirPath() + "/" + department.getId()
            );
        }

        // 3. 更新dir_path
        departmentMapper.updateByPrimaryKeySelective(department);
    }

    /**
     * 删除
     * 删除上级部门自动选择删除上级部门所包含的下级所有部门
     * 根据部门路径批量删除
     * sql语句条件可以使用 /2/5 or /2/5/%
     * @param ids
     */
    @Override
    public void delete(List<Long> ids) {
        //根据id先查出来dir_path
        List<Department> departments = departmentMapper.selectByIds(ids);
        List<String> dirPaths = departments.stream().map(Department::getDirPath).toList();
        //根据路径批量删除
        departmentMapper.deleteByDirPaths(dirPaths);
    }
}
