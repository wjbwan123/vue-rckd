package net.rckd.entity;

import java.util.Date;

/**
 * 公司实体类
 * @author hanyi
 * @date 2017年04月12日
 */
public class Company {
    private Integer id;
    private Integer userId;
    /**
     * 公司名称
     */
    private String name;
    /**
     * 联系人
     */
    private String contact;
    /**
     * 公司地址
     */
    private String address;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
}
