package com.nanbei.pojo;

import lombok.Data;

/**
 * 
 * @TableName t_department
 */
@Data
public class Department {
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
}