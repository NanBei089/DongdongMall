package com.nanbei.mapper;

import com.nanbei.pojo.Department;

/**
 * Department数据库操作Mapper接口
 *
 * @author nanbei
 * @description 针对表【t_department】的数据库操作Mapper
 * @createDate 2026-10-17 00:11:52
 * @Entity com.nanbei.pojo.Department
 */
public interface DepartmentMapper {

    /**
     * 根据主键删除Department
     *
     * @param id 主键ID
     * @return 受影响的行数
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 新增Department
     *
     * @param record Department实体对象
     * @return 受影响的行数
     */
    int insert(Department record);

    /**
     * 选择性新增Department
     * 仅插入实体对象中非null的字段
     *
     * @param record Department实体对象
     * @return 受影响的行数
     */
    int insertSelective(Department record);

    /**
     * 根据主键查询Department
     *
     * @param id 主键ID
     * @return Department实体对象，不存在时返回null
     */
    Department selectByPrimaryKey(Long id);

    /**
     * 根据主键选择性更新Department
     * 仅更新实体对象中非null的字段
     *
     * @param record Department实体对象
     * @return 受影响的行数
     */
    int updateByPrimaryKeySelective(Department record);

    /**
     * 根据主键更新Department
     *
     * @param record Department实体对象
     * @return 受影响的行数
     */
    int updateByPrimaryKey(Department record);

}