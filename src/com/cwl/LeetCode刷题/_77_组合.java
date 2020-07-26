package com.cwl.LeetCode刷题;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 04:39 2020-05-18
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _77_组合
 * @Description TODO
 * @Author:
 * @Date: 2020-05-18 04:39
 * @Version" 1.0
 */
public class _77_组合
{
    //    给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
//    示例:
//
//    输入: n = 4, k = 2
//    输出:
//        [
//        [2,4],
//        [3,4],
//        [2,3],
//        [1,2],
//        [1,3],
//        [1,4],
//        ]
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/combinations
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    static List<List<Integer>> res;

    public static List<List<Integer>> combine(int n, int k)
    {
        //回溯
        res = new ArrayList<>();
        dfs(n, k, 1, new ArrayList<>());
        return res;
    }

    // for + 递归 回溯 + if判断剪枝

    private static void dfs(int n, int k, int cur, List<Integer> list)
    {
        if (k == 0)
        {
            res.add(new ArrayList<>(list));
            return;
        }
        /*
        剪枝：终止条件为 i <= n - k + 1 而不是 i <= n
        原理：当前层的递归是找到 k 个元素，即我们这个 for 循环添加的是 k 个元素中的第一个元素
             然后再递归找剩下的 k - 1 个元素，如果我们添加的这第 1 个元素后，后面剩下的不足 k - 1 个元素，那么最终肯定是不满足条件的
             那么其实就无需进行递归，可以根据这个条件进行剪枝，即每次都预留后面的元素 大于等于 k - 1 个元素
        */
        for (int i = cur; i <= n - k + 1; i++)
        {
            list.add(i);
            dfs(n, k - 1, i + 1, list);
//            list.removeAll();
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args)
    {
        List<List<Integer>> res = combine(4, 2);
        for (List<Integer> x :
                _77_组合.res)
        {
            for (Integer y :
                    x)
            {
                System.out.print(y+" ");
            }
            System.out.println();
        }
    }
}
