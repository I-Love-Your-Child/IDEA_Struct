package com.cwl.JVM;
/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 14:27 2020-05-16
 */

/**
 *
 * @ClassName: 字符串常量池
 * @Description TODO
 * @Author:
 * @Date: 2020-05-16 14:27 
 * @Version" 1.0
 */
public class 字符串常量池
{
    public static void main(String[] args)
    {
        String a = "常量池a";
        String b = "常量池b";
        String c = a+b;
        String tmp = new String("Test_tmp");
        String tmp1 = "abcdefghijklmnopqrstuvwxyz";
        String tmp2 = "abc";
        String tmp3 = "abcd";
        System.out.println(tmp3==tmp2);
        System.out.println(c);
    }
}
