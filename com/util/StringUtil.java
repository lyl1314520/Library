package com.util;

public class StringUtil {
    /*
     * trim()�������ص����ַ��������һ������������������ʼ�ͽ�β����ɾ����
     * ���磺String s="   HelloWorld   ".trim()�Ͱ�"HelloWorld"���뵽s���ˡ�
     */
    
    /*
     * �ж��ַ����Ƿ�Ϊ��
     */
    public static boolean isEmpty(String str) {
        if ((str == null) || "".equals(str.trim())) {
            return true;
        } else {
            return false;
        }
    }
    /*
     * �ж��ַ����Ƿ�Ϊ��
     */
    public static boolean isNotEmpty(String str) {
        if ((str != null) && !"".equals(str.trim())) {
            return true;
        } else {
            return false;
        }
    }
}
