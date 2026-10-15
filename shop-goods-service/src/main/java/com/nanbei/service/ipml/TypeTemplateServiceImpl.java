package com.nanbei.service.ipml;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nanbei.dto.TypeTemplateDto;
import com.nanbei.mapper.TypeTemplateMapper;
import com.nanbei.service.TypeTemplateService;
import com.nanbei.page.PageList;
import com.nanbei.page.PageQueryParams;
import com.nanbei.pojo.TypeTemplate;
import com.nanbei.vo.TypeTemplateVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeTemplateServiceImpl implements TypeTemplateService {
    @Autowired
    private TypeTemplateMapper typeTemplateMapper;

    /**
     * 分页查询
     *
     * @param params 分页参数
     * @return 分页结果
     */
    @Override
    public PageList<TypeTemplateVo> queryByPage(PageQueryParams<TypeTemplate> params) {
        //1.设置分页参数
        Page<TypeTemplate> page = PageHelper.startPage(params.getPageNum(), params.getPageSize());
        //2.执行查询
        List<TypeTemplate> typeTemplates = typeTemplateMapper.selectByPage(params.getParams());
        //3.转换为VO对象
        List<TypeTemplateVo> voList = typeTemplates.stream().map(typeTemplate -> {
            TypeTemplateVo vo = new TypeTemplateVo();
            BeanUtils.copyProperties(typeTemplate, vo);
            return vo;
        }).toList();
        return new PageList<>(page.getTotal(), voList);
    }


    /**
     * 删除
     *
     * @param ids
     */
    @Override
    public void delete(List<Long> ids) {
        typeTemplateMapper.deleteByPrimaryKey(ids);
    }

    /**
     * 添加
     *
     * @param typeTemplateDto
     */
    @Override
    public void add(TypeTemplateDto typeTemplateDto) {
        TypeTemplate typeTemplate = new TypeTemplate();
        BeanUtils.copyProperties(typeTemplateDto, typeTemplate);
        typeTemplateMapper.insert(typeTemplate);

    }

    /**
     * 修改
     *
     * @param typeTemplateDto
     */
    @Override
    public void update(TypeTemplateDto typeTemplateDto) {
        TypeTemplate typeTemplate = new TypeTemplate();
        BeanUtils.copyProperties(typeTemplateDto, typeTemplate);
        typeTemplateMapper.updateByPrimaryKeySelective(typeTemplate);

    }
}
