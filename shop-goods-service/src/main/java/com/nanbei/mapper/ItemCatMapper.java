package com.nanbei.mapper;

import com.nanbei.pojo.ItemCat;

import java.util.List;

/**
 * 商品类目数据库操作Mapper接口
 *
 * @author nanbei
 * @description 针对表【tb_item_cat】的数据库操作Mapper
 * @createDate 2026-10-15 21:25:59
 * @Entity com.nanbei.pojo.ItemCat
 */
public interface ItemCatMapper {


    List<ItemCat> selectAll();

    /**
     * 根据主键删除商品类目
     *
     * @param id 主键ID
     * @return 受影响的行数
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 新增商品类目
     *
     * @param record 商品类目实体对象
     * @return 受影响的行数
     */
    int insert(ItemCat record);

    /**
     * 选择性新增商品类目
     * 仅插入实体对象中非null的字段
     *
     * @param record 商品类目实体对象
     * @return 受影响的行数
     */
    int insertSelective(ItemCat record);

    /**
     * 根据主键查询商品类目
     *
     * @param id 主键ID
     * @return 商品类目实体对象，不存在时返回null
     */
    ItemCat selectByPrimaryKey(Long id);

    /**
     * 根据主键选择性更新商品类目
     * 仅更新实体对象中非null的字段
     *
     * @param record 商品类目实体对象
     * @return 受影响的行数
     */
    int updateByPrimaryKeySelective(ItemCat record);

    /**
     * 根据主键更新商品类目
     *
     * @param record 商品类目实体对象
     * @return 受影响的行数
     */
    int updateByPrimaryKey(ItemCat record);

}