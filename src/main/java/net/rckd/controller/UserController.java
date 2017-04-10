package net.rckd.controller;

import net.rckd.dao.UserDao;
import net.rckd.entity.User;
import net.rckd.service.UserService;
import net.rckd.utils.Constants;
import net.rckd.utils.R;
import net.rckd.utils.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 注册用户管理
 * @author hanyi
 * @date 2017年04月08日
 */
@RestController
@RequestMapping("user")
public class UserController extends AbstractController{
    @Autowired
    private UserService userService;

    /**
     *新增注册用户
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public R save(User user){
        return R.ok();
    }

    /**
     *修改注册用户
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public R update(User user){
        return R.ok();
    }


}
