package com.nanbei.goods.mapper;

import com.nanbei.pojo.SpecificationOption;

/**
 * 规格选项表数据库操作Mapper接口
 *
 * @author nanbei
 * @description 针对表【tb_specification_option】的数据库操作Mapper
 * @createDate 2026-10-13 10:28:17
 * @Entity com.nanbei.goods.pojo.SpecificationOption
 */
public interface SpecificationOptionMapper {

    /**
     * 根据主键删除规格选项表
     *
     * @param id 主键ID
     * @return 受影响的行数
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 新增规格选项表
     *
     * @param record 规格选项表实体对象
     * @return 受影响的行数
     */
    int insert(SpecificationOption record);

    /**
     * 选择性新增规格选项表
     * 仅插入实体对象中非null的字段
     *
     * @param record 规格选项表实体对象
     * @return 受影响的行数
     */
    int insertSelective(SpecificationOption record);

    /**
     * 根据主键查询规格选项表
     *
     * @param id 主键ID
     * @return 规格选项表实体对象，不存在时返回null
     */
    SpecificationOption selectByPrimaryKey(Long id);

    /**
     * 根据主键选择性更新规格选项表
     * 仅更新实体对象中非null的字段
     *
     * @param record 规格选项表实体对象
     * @return 受影响的行数
     */
    int updateByPrimaryKeySelective(SpecificationOption record);

    /**
     * 根据主键更新规格选项表
     *
     * @param record 规格选项表实体对象
     * @return 受影响的行数
     */
    int updateByPrimaryKey(SpecificationOption record);

}