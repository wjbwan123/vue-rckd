package net.rckd.service.impl;

import net.rckd.dao.UserDao;
import net.rckd.entity.User;
import net.rckd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 注册用户管理
 * @author hanyi
 * @date 2017年04月08日
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public User getByAccount(String account) {
        return userDao.queryByAccount(account);
    }
}
