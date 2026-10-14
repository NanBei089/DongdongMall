package com.nanbei.vo;

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
public class SpecAndOptionVo {
    private SpecificationVo specification;

    private List<SpecificationOptionVo> specificationOption;
}
