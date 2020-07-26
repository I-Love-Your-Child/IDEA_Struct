package com.cwl.LeetCode刷题
        ;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 23:01 2020-05-13
 */

/**
 * @ClassName: _44_通配符匹配_动态规划
 * @Description TODO
 * @Author:
 * @Date: 2020-05-13 23:01
 * @Version" 1.0
 */
public class _44_通配符匹配_动态规划
{
    public static boolean isMatch(String s, String p)
    {
        boolean[][] value = new boolean[p.length() + 1][s.length() + 1];
        value[0][0] = true;
        for (int i = 1; i <= s.length(); i++)
        {
            value[0][i] = false;
        }
        for (int i = 1; i <= p.length(); i++)
        {
            if (p.charAt(i - 1) == '*')
            {
                value[i][0] = value[i - 1][0];
                for (int j = 1; j <= s.length(); j++)
                {
                    value[i][j] = (value[i][j - 1] || value[i - 1][j]);
                }
            } else if (p.charAt(i - 1) == '?')
            {
                value[i][0] = false;
                for (int j = 1; j <= s.length(); j++)
                {
                    value[i][j] = value[i - 1][j - 1];
                }
            } else
            {
                value[i][0] = false;
                for (int j = 1; j <= s.length(); j++)
                {
                    value[i][j] = s.charAt(j - 1) == p.charAt(i - 1) && value[i - 1][j - 1];
                }
            }

        }
        return value[p.length()][s.length()];

    }

    public static void main(String[] args)
    {
        String S = "aa";
        String P = "a";
        System.out.println(isMatch(S,P));
    }
}
