package net.rckd.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.annotation.JSONField;
import net.rckd.entity.Region;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 地区工具类
 *
 * @author hanyi
 * @date 2017年04月11日
 */
public class RegionUtils {
    private static CloseableHttpClient client = HttpClients.createDefault();
    private static final String baseUrl = "http://ip.taobao.com/service/getIpInfo.php?ip=";

    //根据ip获得地区信息
    public static Region getRegion(HttpServletRequest request) {
        String ip = getRemoteIp(request);
        Region region = new Region();
        if (ip.equals(Constants.LOCAL_IP)) {
            region.setCode(110100);
            region.setFullName("北京市");
            return region;
        }
        String ipResponse = getIpInfo(ip);
        Response response = null;
        if (ipResponse != null) {
            try {
                response = JSON.parseObject(ipResponse, Response.class);
            } catch (JSONException e) {
                System.out.println("error:" + e.getMessage());
            }
        }
        if (response == null || response.getCode() != 0) {
            //FIXME 记录该用户/浏览器上一次访问时所在的城市,若没有则默认北京
            region.setCode(110100);
            region.setFullName("北京市");
            return region;
        }
        IpInfo info = response.getData();
        //本网站的业务只在中国开放
        if (info.getCountry().equals("中国")) {
            //FIXME 记录该用户/浏览器上一次访问时所在的城市,若没有则默认北京
            region.setCode(110100);
            region.setFullName("北京市");
            return region;
        }
        //todo
        //region = areaService.getByName(info.getCity());
        if (null == region) {
            //FIXME 记录该用户/浏览器上一次访问时所在的城市,若没有则默认北京
            region.setCode(110100);
            region.setFullName("北京市");
            return region;
        }
        return region;
    }

    private static String getIpInfo(String ip) {
        HttpGet httpGet = new HttpGet(baseUrl + ip);
        try {
            HttpResponse response = client.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
                BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent(), "UTF-8"));
                String tmp;
                String content = "";
                while ((tmp = reader.readLine()) != null) {
                    content += tmp + "\r\n";
                }
                return content;
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭流并释放资源
                client.close();
            } catch (IOException e) {
                //防御性容错
                e.printStackTrace();
            }
        }
        return null;
    }

    //根据HttpServletRequest得到用户ip
    private static String getRemoteIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        //ip = "61.51.253.90";
        //ip = "218.25.19.153";
        //0:0:0:0:0:0:0:1: IPV6的形式,win7下可能会出现
        return ip.equals("0:0:0:0:0:0:0:1") ? Constants.LOCAL_IP : ip;
    }

    public static class IpInfo {
        private String country; //国家
        @JSONField(name = "country_id")
        private String countryId; //"CN"
        private String area; //地区名称（华南、华北...）
        @JSONField(name = "area_id")
        private String areaId; //地区编号
        private String region; //省名称
        @JSONField(name = "region_id")
        private String regionId; //省编号
        private String city; //市名称
        @JSONField(name = "city_id")
        private String cityId; //市编号
        private String county; //县名称
        @JSONField(name = "county_id")
        private String countyId; //县编号
        private String isp; //ISP服务商名称（电信/联通/铁通/移动...）
        @JSONField(name = "isp_id")
        private String ispId; //ISP服务商编号
        private String ip; //查询的IP地址

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCountryId() {
            return countryId;
        }

        public void setCountryId(String countryId) {
            this.countryId = countryId;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getAreaId() {
            return areaId;
        }

        public void setAreaId(String areaId) {
            this.areaId = areaId;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getRegionId() {
            return regionId;
        }

        public void setRegionId(String regionId) {
            this.regionId = regionId;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCityId() {
            return cityId;
        }

        public void setCityId(String cityId) {
            this.cityId = cityId;
        }

        public String getCounty() {
            return county;
        }

        public void setCounty(String county) {
            this.county = county;
        }

        public String getCountyId() {
            return countyId;
        }

        public void setCountyId(String countyId) {
            this.countyId = countyId;
        }

        public String getIsp() {
            return isp;
        }

        public void setIsp(String isp) {
            this.isp = isp;
        }

        public String getIspId() {
            return ispId;
        }

        public void setIspId(String ispId) {
            this.ispId = ispId;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }
    }

    public static class Response {
        private int code;//状态码，正常为0，异常的时候为非0
        private IpInfo data;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public IpInfo getData() {
            return data;
        }

        public void setData(IpInfo data) {
            this.data = data;
        }
    }
}
