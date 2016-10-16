package com.javalong.lib.utils;

/**
 * Created by javalong on 16/10/16.
 */
public class StringUtils {

    /**
     * 判断字符串是否相等
     * @param str1
     * @param str2
     * @return
     */
    public static boolean equals(String str1,String str2){
        if(str1==null&&str2==null)
            return true;
        if(str1==null||str2==null)
            return false;
        return str1.equals(str2);
    }

    /**
     * 判断字符串是否为空
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0 || str.equalsIgnoreCase("null");
    }
}
