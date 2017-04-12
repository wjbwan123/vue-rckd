package net.rckd.entity;

import java.util.List;

/**
 * 地区实体类
 *
 * @author hanyi
 * @date 2017-03-23 20:59
 */
public class Region {
    /**
     * 地区id
     */
    private Integer code;
    /**
     * 父亲id
     */
    private Integer parentCode;
    /**
     * 名字简称
     */
    private String name;
    /**
     * 名字全称
     */
    private String fullName;
    /**
     * 子集合
     */
    private List<Region> children;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getParentCode() {
        return parentCode;
    }

    public void setParentCode(Integer parentCode) {
        this.parentCode = parentCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Region> getChildren() {
        return children;
    }

    public void setChildren(List<Region> children) {
        this.children = children;
    }
}
