package com.nanbei.controller;

import com.nanbei.result.Result;
import com.nanbei.service.ItemCatService;
import com.nanbei.vo.ItemCatVo;
import com.nanbei.vo.TypeTemplateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itemCat")
public class ItemCatController {
    @Autowired
    private ItemCatService itemCatService;

    /**
     * 查询所有商品分类
     * @return
     */
    @GetMapping("/queryAll")
    public Result<List<ItemCatVo>> queryAll() {
        List<ItemCatVo> itemCatVoList = itemCatService.queryAll();
        return Result.success(itemCatVoList);
    }

    /**
     * 根据id查询商品分类
     * @param id
     * @return
     */
    @GetMapping("/queryById/{id}")
    public Result<TypeTemplateVo> queryById(@PathVariable("id") Long id) {
        TypeTemplateVo typeTemplate = itemCatService.queryTemplateById(id);
        return Result.success(typeTemplate);
    }

    /**
     * 修改商品类目
     * @param itemCatVo
     * @return
     */
    @PostMapping("/update")
    public Result<Void> update(ItemCatVo itemCatVo) {
        itemCatService.update(itemCatVo);
        return Result.success();
    }
}
