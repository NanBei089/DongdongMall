package com.nanbei.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 模板表
 * @TableName tb_type_template
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class TypeTemplate {
    /**
     * 
     */
    private Long id;

    /**
     * 模板名称
     */
    private String name;

    /**
     * 关联规格
     */
    private String specIds;

    /**
     * 关联品牌
     */
    private String brandIds;

    /**
     * 自定义属性
     */
    private String customAttributeItems;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TypeTemplate other = (TypeTemplate) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getSpecIds() == null ? other.getSpecIds() == null : this.getSpecIds().equals(other.getSpecIds()))
            && (this.getBrandIds() == null ? other.getBrandIds() == null : this.getBrandIds().equals(other.getBrandIds()))
            && (this.getCustomAttributeItems() == null ? other.getCustomAttributeItems() == null : this.getCustomAttributeItems().equals(other.getCustomAttributeItems()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getSpecIds() == null) ? 0 : getSpecIds().hashCode());
        result = prime * result + ((getBrandIds() == null) ? 0 : getBrandIds().hashCode());
        result = prime * result + ((getCustomAttributeItems() == null) ? 0 : getCustomAttributeItems().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", specIds=").append(specIds);
        sb.append(", brandIds=").append(brandIds);
        sb.append(", customAttributeItems=").append(customAttributeItems);
        sb.append("]");
        return sb.toString();
    }
}