package com.cwl.LeetCode刷题;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 14:03 2020-05-17
 */

/**
 * @ClassName: _58_最后一个单词的长度
 * @Description TODO
 * @Author:
 * @Date: 2020-05-17 14:03
 * @Version" 1.0
 */
public class _58_最后一个单词的长度
{
    public int lengthOfLastWord(String s)
    {
        if(s.charAt(s.length()-1)==' ')
        {
            return 0;
        }
        String[] s1 = s.split(" ");
        return s1[s1.length-1].length();
    }

    public static void main(String[] args)
    {
        String x = "a ";
        String[] s = x.split(" ");
        for (String x1 :
                s)
        {
            System.out.println(x1);
        }
    }
}
