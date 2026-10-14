package com.nanbei.goods.mapper;

import com.nanbei.pojo.Specification;
import com.nanbei.vo.SpecificationVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 规格表数据库操作Mapper接口
 *
 * @author nanbei
 * @description 针对表【tb_specification】的数据库操作Mapper
 * @createDate 2026-10-13 10:28:17
 * @Entity com.nanbei.goods.pojo.Specification
 */
public interface SpecificationMapper {

    /**
     * 分页查询规格表
     * @param params 分页查询参数
     * @return 规格表实体对象列表
     */
    List<Specification> selectList(SpecificationVo params);

    /**
     * 根据主键删除规格表
     *
     * @param id 主键ID
     * @return 受影响的行数
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 新增规格表
     *
     * @param record 规格表实体对象
     * @return 受影响的行数
     */
    int insertSpecification(Specification record);

    /**
     * 根据主键查询规格表
     *
     * @param id 主键ID
     * @return 规格表实体对象，不存在时返回null
     */
    Specification selectByPrimaryKey(Long id);

    /**
     * 根据主键选择性更新规格表
     * 仅更新实体对象中非null的字段
     *
     * @param record 规格表实体对象
     * @return 受影响的行数
     */
    int updateByPrimaryKeySelective(Specification record);

    /**
     * 根据主键更新规格表
     *
     * @param record 规格表实体对象
     * @return 受影响的行数
     */
    int updateByPrimaryKey(Specification record);

    void deleteBatch(@Param("ids") List<Long> ids);
}