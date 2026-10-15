package com.nanbei.service.ipml;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nanbei.dto.SpecAndOptionDto;
import com.nanbei.enums.ExceptionEnum;
import com.nanbei.exception.BusinessException;
import com.nanbei.mapper.SpecificationMapper;
import com.nanbei.mapper.SpecificationOptionMapper;
import com.nanbei.service.SpecificationService;
import com.nanbei.page.PageList;
import com.nanbei.page.PageQueryParams;
import com.nanbei.pojo.SpecAndOption;
import com.nanbei.pojo.Specification;
import com.nanbei.pojo.SpecificationOption;
import com.nanbei.vo.SpecificationOptionVo;
import com.nanbei.vo.SpecificationVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SpecificationServiceImpl implements SpecificationService {
    @Autowired
    private SpecificationMapper specificationMapper;

    @Autowired
    private SpecificationOptionMapper specificationOptionMapper;

    /**
     * 分页查询规格
     * @param params 分页查询参数
     * @return 规格表实体对象列表
     */
    @Override
    public PageList<SpecificationVo> selectSpecificationList(PageQueryParams<SpecificationVo> params) {
        //1.设置分页参数
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        //2.获取数据
        List<Specification> list = specificationMapper.selectList(params.getParams());
        //3.获取分页信息
        PageInfo<Specification> pageInfo = new PageInfo<>(list);
        //4.数据转换
        List<SpecificationVo> specificationVoList = pageInfo.getList().stream().map(specification ->
                new SpecificationVo(specification.getId(), specification.getSpecName())
        ).toList();
        //5.返回结果
        return new PageList<>(pageInfo.getTotal(), specificationVoList);
    }


    /**
     * 先删除规格相关数据，再删除规格
     * @param id 主键ID
     * @return 受影响的行数
     */
    @Override
    @Transactional
    public void deleteSpecification(Long id) {
        //1.删除规格相关数据
        specificationOptionMapper.deleteBySpecId(id);
        //2.删除规格
        specificationMapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量删除规格
     */
    @Transactional
    @Override
    public void deleteBatchSpecification(List<Long> ids) {
        if (ids.isEmpty()) {
            return;
        }
        //1.删除规格相关数据
        specificationOptionMapper.deleteBatch(ids);
        //2.删除规格
        specificationMapper.deleteBatch(ids);
    }

    /**
     * 新增规格
     *
     * @param record 规格表实体对象
     * @return 受影响的行数
     */
    @Override
    @Transactional
    public void insertSpecification(SpecAndOption record) {
        validateSpecification(record);
        Specification specification = record.getSpecification();
        List<SpecificationOption> options = record.getSpecificationOption();
        //先插入规格，返回自增的id
        specificationMapper.insertSpecification(specification);
        Long id = specification.getId();
        //没有选项时，只保存规格名称
        if (!options.isEmpty()) {
            for (SpecificationOption option : options) {
                option.setSpecId(id);
            }
            specificationOptionMapper.insertOption(options);
        }

    }


    /**
     * 保存完整的规格及选项表单
     *
     * @param record 规格表实体对象
     * @return 受影响的行数
     */
    @Override
    @Transactional
    public void updateSpecification(SpecAndOption record) {
        validateSpecification(record);
        Specification specification = record.getSpecification();
        List<SpecificationOption> options = record.getSpecificationOption();
        Long specId = specification.getId();
        findSpecification(specId);

        // 1. 先把所有旧选项 ID 放进待删除集合
        Set<Long> deleteIds = new HashSet<>();
        for (SpecificationOption oldOption : specificationOptionMapper.selectBySpecId(specId)) {
            deleteIds.add(oldOption.getId());
        }

        // 2. 修改规格名称
        specificationMapper.updateByPrimaryKey(specification);

        // 3. 没有 ID 就新增，有 ID 就修改并从待删除集合中移除
        for (SpecificationOption option : options) {
            option.setSpecId(specId);
            if (option.getId() == null) {
                specificationOptionMapper.insertSelective(option);
            } else {
                if (!deleteIds.remove(option.getId())) {
                    throw new BusinessException("选项不存在、重复或不属于当前规格");
                }
                specificationOptionMapper.updateByPrimaryKey(option);
            }
        }

        // 4. 集合里剩下的，就是页面上已经删除的选项
        for (Long optionId : deleteIds) {
            specificationOptionMapper.deleteByPrimaryKey(optionId);
        }
    }


    /**
     * 回显数据
     *
     * @param id 主键ID
     * @return 用于回显的规格详情 VO
     */
    @Override
    public SpecAndOptionDto selectByPrimaryKey(Long id) {
        //1.查询规格
        Specification specification = findSpecification(id);
        //2.查询规格选项
        List<SpecificationOption> options = specificationOptionMapper.selectBySpecId(id);
        //3.转换为 VO，返回对象不直接使用数据库实体
        SpecificationVo specificationVo = new SpecificationVo(specification.getId(), specification.getSpecName());
        List<SpecificationOptionVo> optionVoList = options.stream().map(option ->
                new SpecificationOptionVo(option.getId(), option.getOptionName(), option.getSpecId(), option.getOrders())
        ).toList();
        return new SpecAndOptionDto(specificationVo, optionVoList);
    }

    /**
     * 查询所有规格
     *
     * @return 规格列表
     */
    @Override
    public List<SpecificationVo> queryAll() {
        List<Specification> specifications = specificationMapper.selectList(null);
        return specifications.stream().map(specification ->
                {
                    SpecificationVo specificationVo = new SpecificationVo();
                    BeanUtils.copyProperties(specification, specificationVo);
                    return specificationVo;
                }
        ).toList();

    }

    private void validateSpecification(SpecAndOption record) {
        if (record == null || record.getSpecification() == null) {
            throw new BusinessException(ExceptionEnum.PARAM_ERROR.getCode(), "规格信息不能为空");
        }
        if (!StringUtils.hasText(record.getSpecification().getSpecName())) {
            throw new BusinessException(ExceptionEnum.PARAM_ERROR.getCode(), "规格名称不能为空");
        }
        if (record.getSpecificationOption() == null) {
            throw new BusinessException(ExceptionEnum.PARAM_ERROR.getCode(), "规格选项列表不能为空，无选项请传空数组");
        }
        for (SpecificationOption option : record.getSpecificationOption()) {
            if (option == null || !StringUtils.hasText(option.getOptionName())) {
                throw new BusinessException(ExceptionEnum.PARAM_ERROR.getCode(), "规格选项及选项名称不能为空");
            }
        }
    }

    /**
     * 根据ID查询规格
     * @param id
     * @return
     */
    private Specification findSpecification(Long id) {
        if (id == null || id <= 0) {
            throw new BusinessException(ExceptionEnum.PARAM_ERROR.getCode(), "规格 ID 必须为正整数");
        }
        Specification specification = specificationMapper.selectByPrimaryKey(id);
        if (specification == null) {
            throw new BusinessException("规格不存在");
        }
        return specification;
    }

}
