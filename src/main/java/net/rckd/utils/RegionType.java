package net.rckd.utils;

/**
 * 地区类型
 * @author hanyi
 * @date 2017-03-23 20:59
 */
public enum RegionType {
    /**
     * 省
     */
    PROVINCE(1),
    /**
     * 市
     */
    CITY(2),
    /**
     * 县
     */
    TOWN(3);

    private int value;

    private RegionType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
