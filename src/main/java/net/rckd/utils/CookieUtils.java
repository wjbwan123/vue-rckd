package net.rckd.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Cookie工具类
 *
 * @author hanyi
 * @date 2017年03月18日
 */
public class CookieUtils {
    /**
     * 添加cookie
     *
     * @param response
     * @param name
     * @param value
     * @param maxAge   有效时间
     */
    public static void saveCookie(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        maxAge = maxAge * 60 * 60 * 24;
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        cookie.setDomain("/"); // cookie作用域
        response.addCookie(cookie);
    }

    /**
     * 通过cookie name 获取 cookie value
     *
     * @param request
     * @param cookieName
     * @return
     */
    public static String getCookieValue(HttpServletRequest request, String cookieName) {
        Cookie cookies[] = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    /**
     * 删除cookie
     *
     * @param response
     * @param cookieName
     */
    public static void removeCookie(HttpServletResponse response, String cookieName) {
        Cookie cookie = new Cookie(cookieName, null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}
