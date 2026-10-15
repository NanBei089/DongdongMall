package com.nanbei.dto;

import com.nanbei.vo.SpecificationOptionVo;
import com.nanbei.vo.SpecificationVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 规格详情，用于编辑页面回显。
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpecAndOptionDto {
    private SpecificationVo specification;

    private List<SpecificationOptionVo> specificationOption;
}
