package net.rckd.service;

import net.rckd.entity.User;

/**
 * 注册用户
 * @author hanyi
 * @date 2017年04月08日
 */
public interface UserService {
    public User getByAccount(String account);
    public void save(User user);
    public void update(User user);
}
