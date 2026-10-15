package com.nanbei.mapper;

import com.nanbei.pojo.TypeTemplate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 模板表数据库操作Mapper接口
 *
 * @author nanbei
 * @description 针对表【tb_type_template】的数据库操作Mapper
 * @createDate 2026-10-13 10:28:17
 * @Entity com.nanbei.goods.pojo.TypeTemplate
 */
public interface TypeTemplateMapper {

    /**
     * 根据条件查询模板列表（配合PageHelper实现分页）
     *
     * @param typeTemplate 查询条件
     * @return 模板列表
     */
    List<TypeTemplate> selectByPage(@Param("type") TypeTemplate typeTemplate);

    /**
     * 根据主键删除模板表
     *
     * @param ids 主键ID
     * @return 受影响的行数
     */
    int deleteByPrimaryKey(@Param("ids") List<Long> ids);

    /**
     * 新增模板表
     *
     * @param record 模板表实体对象
     * @return 受影响的行数
     */
    int insert(TypeTemplate record);

    /**
     * 选择性新增模板表
     * 仅插入实体对象中非null的字段
     *
     * @param record 模板表实体对象
     * @return 受影响的行数
     */
    int insertSelective(TypeTemplate record);

    /**
     * 根据主键查询模板表
     *
     * @param id 主键ID
     * @return 模板表实体对象，不存在时返回null
     */
    TypeTemplate selectByPrimaryKey(Long id);

    /**
     * 根据主键选择性更新模板表
     * 仅更新实体对象中非null的字段
     *
     * @param record 模板表实体对象
     * @return 受影响的行数
     */
    int updateByPrimaryKeySelective(TypeTemplate record);

    /**
     * 根据主键更新模板表
     *
     * @param record 模板表实体对象
     * @return 受影响的行数
     */
    int updateByPrimaryKey(TypeTemplate record);

}