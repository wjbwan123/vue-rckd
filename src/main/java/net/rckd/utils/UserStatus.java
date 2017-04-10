package net.rckd.utils;

/**
 * 用户状态
 * @author hanyi
 * @date 2017-03-23 20:59
 */
public enum UserStatus {
    /**
     * 禁用
     */
    DISABLE(1),
    /**
     * 正常
     */
    NORMAL(2);

    private int value;

    private UserStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
