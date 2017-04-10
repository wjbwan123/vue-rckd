package net.rckd.service;

import net.rckd.entity.User;

/**
 * @author hanyi
 * @date 2017年04月08日
 */
public interface UserService {
    public User getByAccount(String account);
}
