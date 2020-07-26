package com.cwl.Test;
/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 15:41 2020-05-09
 */

/**
 * @ClassName: KMP测试
 * @Description TODO
 * @Author: KMP测试
 * @Date: 2020-05-09 15:41
 * @Version" 1.0
 */
public class KMP测试
{
    public static int kmp(String str, String pattern)
    {
        int[] nexts = getNexts(pattern);
        int j = 0;
        for (int i = 0; i < str.length(); i++)
        {
            while (j > 0 && str.charAt(i) != pattern.charAt(j))
            {
                j = nexts[j];
            }
            if (str.charAt(i) == pattern.charAt(j))
            {
                j++;
            }
            if (j == pattern.length())
            {
                return i - j + 1;
            }
        }
        return -1;
    }

    public static int[] getNexts(String pattern)
    {
        int[] nexts = new int[pattern.length()];
        int j = 0;
        for (int i = 2; i < pattern.length(); i++)
        {
            while (j != 0 && pattern.charAt(j) != pattern.charAt(i - 1))
            {
                j = nexts[j];
            }
            if (pattern.charAt(j) == pattern.charAt(i - 1))
            {
                j++;
                nexts[i] = j;
            }
        }
        return nexts;
    }

    public static void main(String[] args)
    {
        String str = "ATGTGAGCTGGTGTGTGCFAA";
        String pattern = "GTGTGCF";
        int index = kmp(str, pattern);
        System.out.println(index);
        /*
        输出为12 正确
         */
        System.out.println(kmp("ABCDEFGHH", "HHY"));
        System.out.println(kmp("AAA", "AAA"));
    }
}
