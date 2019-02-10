package com.util;

public class StringUtil {
    /*
     * trim()方法返回调用字符串对象的一个副本，但是所有起始和结尾都被删掉了
     * 例如：String s="   HelloWorld   ".trim()就把"HelloWorld"存入到s中了。
     */
    
    /*
     * 判断字符串是否为空
     */
    public static boolean isEmpty(String str) {
        if ((str == null) || "".equals(str.trim())) {
            return true;
        } else {
            return false;
        }
    }
    /*
     * 判断字符串是否不为空
     */
    public static boolean isNotEmpty(String str) {
        if ((str != null) && !"".equals(str.trim())) {
            return true;
        } else {
            return false;
        }
    }
}
