package com.nanbei.goods.mapper;

import com.nanbei.pojo.TypeTemplate;

/**
* @author nanbei
* @description 针对表【tb_type_template(模板表)】的数据库操作Mapper
* @createDate 2026-10-13 10:04:59
* @Entity com.nanbei.goods.pojo.TypeTemplate
*/
public interface TypeTemplateMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TypeTemplate record);

    int insertSelective(TypeTemplate record);

    TypeTemplate selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TypeTemplate record);

    int updateByPrimaryKey(TypeTemplate record);

}
