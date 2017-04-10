package net.rckd.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @author hanyi
 * @date 2017-03-23 20:59
 */
public class Md5Utils {

    public static String getMd5String(String password){
        //盐
        final String salt = "dfdgdfgfd";
        //散列次数
        final int hashIterations = 1;
        Md5Hash md5 = new Md5Hash(password, salt, hashIterations);
        return md5.toString();
    }
}
