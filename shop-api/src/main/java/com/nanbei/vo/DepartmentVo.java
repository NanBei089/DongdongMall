package com.nanbei.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 
 * @TableName t_department
 */
@Data
public class DepartmentVo {
    /**
     * 
     */
    private Long id;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 部门的上级分类层级id
     */
    private String dirPath;

    /**
     * 上级部门
     */
    private Long parentId;

    /**
     * 子节点
     * @JsonInclude(JsonInclude.Include.NON_EMPTY) 忽略空值
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DepartmentVo> children;
}