package com.nanbei.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 新增、修改规格时提交的完整表单。
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpecAndOption {
    private Specification specification;

    private List<SpecificationOption> specificationOption;
}
