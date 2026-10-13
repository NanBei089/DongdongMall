package com.nanbei.goods.mapper;

import com.nanbei.pojo.SpecificationOption;

/**
* @author nanbei
* @description 针对表【tb_specification_option(规格选项表)】的数据库操作Mapper
* @createDate 2026-10-13 10:04:59
* @Entity com.nanbei.goods.pojo.SpecificationOption
*/
public interface SpecificationOptionMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SpecificationOption record);

    int insertSelective(SpecificationOption record);

    SpecificationOption selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SpecificationOption record);

    int updateByPrimaryKey(SpecificationOption record);

}
