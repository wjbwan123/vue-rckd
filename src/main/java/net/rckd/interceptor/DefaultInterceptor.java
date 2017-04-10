package net.rckd.interceptor;

import com.alibaba.fastjson.JSONException;
import com.google.gson.Gson;
import net.rckd.entity.Region;
import net.rckd.utils.Constants;
import net.rckd.utils.CookieUtils;
import net.rckd.utils.ShiroUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 默认拦截器
 *
 * @author hanyi
 * @date 2017年04月10日
 */
public class DefaultInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        Region region = (Region) ShiroUtils.getSessionAttribute(Constants.AREA_SESSION_KEY);
        // 获取域名
        String serverName = request.getServerName();
        if (isSecondLevelDomain(serverName)) {
            //先从redis里根据index取area 取不到从数据库里取
            Map<String, Object> map = new HashMap<>();
            map.put("index", serverName);
            //region = areaService.getByObject(map);
        }
        //判断session里area是不是为空
        if (region == null) {
            //如果area为null，cookie里取area
            String regionJson = CookieUtils.getCookieValue(request, Constants.AREA_COOKIE_KEY);
            if (regionJson != null) {
                Gson gson = new Gson();
                try {
                    region = gson.fromJson(regionJson, Region.class);
                } catch (JSONException e) {
                    region = null;
                }
            }
        }
        if (region == null) {
            //如果area为null，根据定位地址
            //todo
        }
        if (region == null) {
            //如果area为null，取默认地区
            //todo
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion");
    }

    //是否是二级域名
    private boolean isSecondLevelDomain(String serverName) {
        boolean result = StringUtils.isNotBlank(serverName)
                && !serverName.equals("www") && !serverName.equals("localhost")
                && !serverName.equals("127.0.0.1");
        return result;
    }
}
