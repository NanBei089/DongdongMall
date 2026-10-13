package com.nanbei.goods.mapper;

import com.nanbei.pojo.Specification;

/**
* @author nanbei
* @description 针对表【tb_specification(规格表)】的数据库操作Mapper
* @createDate 2026-10-13 09:58:10
* @Entity com.nanbei.goods.pojo.Specification
*/
public interface SpecificationMapper {

    /**
     * 根据主键删除
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 插入数据
     *
     * @param record 数据对象
     * @return 影响行数
     */
    int insert(Specification record);

    /**
     * 插入数据（字段值为空也会插入）
     *
     * @param record 数据对象
     * @return 影响行数
     */
    int insertSelective(Specification record);

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 数据对象
     */
    Specification selectByPrimaryKey(Long id);

    /**
     * 根据主键更新数据（字段值为空不会更新）
     *
     * @param record 数据对象
     * @return 影响行数
     */
    int updateByPrimaryKeySelective(Specification record);

    /**
     * 根据主键更新数据
     *
     * @param record 数据对象
     * @return 影响行数
     */
    int updateByPrimaryKey(Specification record);

}
