package com.nanbei.service.ipml;

import com.nanbei.mapper.ItemCatMapper;
import com.nanbei.mapper.TypeTemplateMapper;
import com.nanbei.pojo.ItemCat;
import com.nanbei.pojo.TypeTemplate;
import com.nanbei.service.ItemCatService;
import com.nanbei.vo.ItemCatVo;
import com.nanbei.vo.TypeTemplateVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService {
    @Autowired
    private ItemCatMapper itemCatMapper;
    @Autowired
    private TypeTemplateMapper typeTemplateMapper;

    /**
     * 套娃
     * @param itemCats 商品类目列表
     * @param parentId 父类目id
     */
    public List<ItemCatVo> getTree(List<ItemCat> itemCats, Long parentId) {
        // 使用流式编程,过滤出parentId等于parentid的
        List<ItemCatVo> itemCatVos = itemCats.stream().filter(itemCat -> itemCat.getParentId().equals(parentId))
                .map(itemCat -> {
                    ItemCatVo itemCatVo = new ItemCatVo();
                    itemCatVo.setId(itemCat.getId());
                    itemCatVo.setName(itemCat.getName());
                    itemCatVo.setParentId(itemCat.getParentId());
                    itemCatVo.setChildren(getTree(itemCats, itemCat.getId()));
                    return itemCatVo;
                }).toList();

        return itemCatVos;
    }


    /**
     * 查询所有商品类目
     * 返回数据需要是树形结构
     * 数据结构：
     * {[{},{}],[],[]}大概这样的
     */
    @Override
    public List<ItemCatVo> queryAll() {
        List<ItemCat> itemCats = itemCatMapper.selectAll();
        if (itemCats == null){
            itemCats=new ArrayList<>();
        }
        return getTree(itemCats, 0L);
    }

    /**
     * 修改商品类目
     *
     * @param itemCatVo
     */
    @Override
    public void update(ItemCatVo itemCatVo) {
        //数据转换
        ItemCat itemCat = new ItemCat();
        BeanUtils.copyProperties(itemCatVo, itemCat);
        itemCatMapper.updateByPrimaryKeySelective(itemCat);
    }

    /**
     * 根据id查询商品类目
     *
     * @param id
     * @return
     */
    @Override
    public TypeTemplateVo queryTemplateById(Long id) {
        //查数据
        ItemCat itemCat = itemCatMapper.selectByPrimaryKey(id);
        //根据商品类目查询规格参数
        TypeTemplate typeTemplate = typeTemplateMapper.selectByPrimaryKey(itemCat.getTypeId());
        //数据转换
        TypeTemplateVo typeTemplateVo = new TypeTemplateVo();
        BeanUtils.copyProperties(typeTemplate, typeTemplateVo);
        return typeTemplateVo;
    }
}
