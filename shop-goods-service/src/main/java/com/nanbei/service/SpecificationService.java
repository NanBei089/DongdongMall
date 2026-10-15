package com.nanbei.service;

import com.nanbei.dto.SpecAndOptionDto;
import com.nanbei.page.PageList;
import com.nanbei.page.PageQueryParams;
import com.nanbei.pojo.SpecAndOption;
import com.nanbei.vo.SpecificationVo;

import java.util.List;

/**
 * 规格表数据库操作Service接口
 */
public interface SpecificationService {


    /**
     * 分页查询规格表
     * @param params 分页查询参数
     * @return 规格表实体对象列表
     */
    PageList<SpecificationVo> selectSpecificationList(PageQueryParams<SpecificationVo> params);

    /**
     * 先删除商品和规格的关联信息，再删除规格信息
     * @param id 主键ID
     * @return 受影响的行数
     */
    void deleteSpecification(Long id);

    /**
     * 批量删除规格信息
     * @param ids 主键ID列表
     * @return 受影响的行数
     */
    void deleteBatchSpecification(List<Long> ids);

    /**
     * 新增规格信息
     *
     * @param record 规格表实体对象
     * @return 受影响的行数
     */
    void insertSpecification(SpecAndOption record);

    /**
     * 修改规格信息
     *
     * @param record 规格表实体对象
     * @return 受影响的行数
     */
    void updateSpecification(SpecAndOption record);

    /**
     * 回显数据
     *
     * @param id 主键ID
     * @return 规格及选项的详情，不存在时抛出异常
     */
    SpecAndOptionDto selectByPrimaryKey(Long id);


    List<SpecificationVo> queryAll();
}
