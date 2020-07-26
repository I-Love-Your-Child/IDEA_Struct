package com.cwl.算法;


/**
 * @Author: book
 * @Description: KMP算法
 * 时间复杂度：O(m+n)
 * 空间复杂度 O(m)
 * @Date: 14:55 2020-05-09
 * @Param:
 * @Return:
 *
 */
public class KMP算法
{
    /**
     * @Author: book
     * @Description: KMP算法主函数
     * @Date: 15:08 2020-05-09
     * @Param: [主串str, 模式串pattern]
     * @Return: int
     *
     */
    public static int kmp(String str, String pattern)
    {
        // 预处理，生成next数组
        int[] next = getNexts(pattern);
        int j = 0;
        // 主循环  遍历是S主串的循环  O(n)
        /*
         主串采用的是最长后缀子串，所以不需要回溯
         子串借助next数组可以实现快速回溯到最长前缀子串
         */
        for (int i = 0; i < str.length(); i++)
        {
            while (j > 0 && str.charAt(i) != pattern.charAt(j))
            {
                //遇到坏字符的时候，查询next数组并且改变字符串的起点
                j = next[j];
            }
            if (str.charAt(i) == pattern.charAt(j))
            {
                j++;
            }
            if (j == pattern.length())
            {
                //匹配成功，返回下标
                return i - pattern.length() + 1;
            }
        }
        return -1;
    }
    //生成Next数组
    /**
     * @Author: book
     * @Description:
     * @Date: 15:08 2020-05-09
     * @Param: [模式串pattern]
     * @Return: int[]
     *
     */
    private static int[] getNexts(String pattern)
    {
        int[] next = new int[pattern.length()];
        /**
         * i 表示已匹配前缀的下一个位置  ===> 也就是待填充的数组下标
         * j 表示最长可匹配前缀子串的下一个位置 ===> 也就是待填充的数组元素值。
         */
        int j = 0;
        for (int i = 2; i < pattern.length(); ++i)
        {
            while (j != 0 && pattern.charAt(j) != pattern.charAt(i - 1))
            {
                //从next[i-1]的求解回溯到next[j]
                j = next[j];
            }
            if (pattern.charAt(j) == pattern.charAt(i - 1))
            {
                j++;
                next[i] = j;
            }
        }
        return  next;
    }

    public static void main(String[] args)
    {
        String str = "ATGTGAGCTGGTGTGTGCFAA";
        String pattern = "GTGTGCF";
        int index = kmp(str,pattern);
        System.out.println(index);
        /*
        输出为12 正确
         */
        System.out.println(kmp("ABCDEFGHH","HHY"));
        System.out.println(kmp("AAA","AAA"));
    }
}
