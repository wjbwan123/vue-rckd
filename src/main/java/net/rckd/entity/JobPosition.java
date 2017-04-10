package net.rckd.entity;

/**
 * 职位分类
 * @author hanyi
 * @date 2017年04月10日
 */
public class JobPosition {
    private Integer id;
    private Integer positionNo;
    private String positionName;
    private Integer parentNo;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPositionNo() {
        return positionNo;
    }

    public void setPositionNo(Integer positionNo) {
        this.positionNo = positionNo;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Integer getParentNo() {
        return parentNo;
    }

    public void setParentNo(Integer parentNo) {
        this.parentNo = parentNo;
    }
}
