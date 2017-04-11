package net.rckd.service;

import net.rckd.entity.User;

/**
 * 注册用户
 *
 * @author hanyi
 * @date 2017年04月08日
 */
public interface UserService {
    User getByAccount(String account);

    void save(User user);

    void update(User user);
}
