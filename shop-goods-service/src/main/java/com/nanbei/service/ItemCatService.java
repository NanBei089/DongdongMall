package com.nanbei.service;


import com.nanbei.vo.ItemCatVo;
import com.nanbei.vo.TypeTemplateVo;

import java.util.List;

public interface ItemCatService {

    /**
     * 查询所有商品类目
     * 返回数据需要是树形结构
     * 数据结构：
     * {[{},{}],[],[]}大概这样的
     * {
     *     "id":1,
     *     "text":"手机",
     *     "children":[
     *         {
     *             "id":1,
     *             "text":"手机"
     *             "children":[
     *                 {
     *                     "id":1,
     *                     "text":"手机"
     *                 }
     *             ]
     *         }
     *     ]
     * }
     */
    List<ItemCatVo> queryAll();

    /**
     * 修改商品类目
     * @param itemCatVo
     */
    void update(ItemCatVo itemCatVo);

    /**
     * 根据id查询商品类目
     * @param id
     * @return
     */
    TypeTemplateVo queryTemplateById(Long id);
}
