package com.cwl.LeetCode刷题;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 00:07 2020-05-16
 */

import java.util.*;

/**
 * @ClassName: _49_字母异位词分组
 * @Description TODO
 * @Author:
 * @Date: 2020-05-16 00:07
 * @Version" 1.0
 */
public class _49_字母异位词分组
{
    public static List<List<String>> groupAnagrams(String[] strs)
    {
        //返回值是List List里面是List 装的String  定义一个HashMap 值为List
        Map<String, List> map = new HashMap<String, List>();
        for (String i : strs)
        {
            //将字符串转换成数组
            char[] arr = i.toCharArray();
            //将字符数组排序 eg："tea" -> "aet"
            Arrays.sort(arr);
            //再次将arr化为String
            String str = String.valueOf(arr);
            if (!map.containsKey(str))
            {
                //若不存在建立映射关系 排序后的字符串—>新的List集合（装未排序的异位词）
                map.put(str, new ArrayList());
            }
            //建立映射关系户后添加 以及存在映射关系后添加单词
            map.get(str).add(i);
        }
        //返回值是List集合 通过构造器 构造一个包含指定 collection 的元素的列表
        return new ArrayList(map.values());
    }

    private static void print(List<List<String>> lists)
    {
        for (List<String> list:lists)
        {
           for (String s : list)
           {
               System.out.print(s + " ");
           }
           System.out.println();
        }
    }

    public static void main(String[] args)
    {
        String[] test = {"eat", "tea", "tan", "ate", "nat", "bat"};
        print(groupAnagrams(test));
    }

    /** =====> 输出:
     *
     * eat tea ate
     * bat
     * tan nat
     */
}
