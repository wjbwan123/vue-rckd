package net.rckd.controller;

import net.rckd.entity.User;
import net.rckd.utils.Constants;
import net.rckd.utils.ShiroUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面视图
 *
 * @author hanyi
 * @date 2017年04月08日
 */
@Controller
public class PageController extends AbstractController {

    /**
     * 首页视图
     */
    @RequestMapping("/")
    public String index() {
        return "index.html";
    }

    /**
     * 公共视图
     */
    @RequestMapping("{module}/{url}.html")
    public String commonPage(@PathVariable("module") String module, @PathVariable("url") String url) {
        if (StringUtils.isBlank(module) || StringUtils.isBlank(url)) {
            return "error/404.html";
        }
        if (module.equals(Constants.LOGIN_FILTER_PACKAGE) && !ShiroUtils.isLogin()) {
            //没有登陆跳到登陆页面
            return "login.html";
        }
        return module + "/" + url + ".html";
    }
}
