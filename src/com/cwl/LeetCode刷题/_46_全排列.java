package com.cwl.LeetCode刷题;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 01:06 2020-05-15
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _46_全排列
 * @Description TODO
 * @Author:
 * @Date: 2020-05-15 01:06
 * @Version" 1.0
 */

//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
//        示例:
//
//        输入: [1,2,3]
//        输出:
//        [
//        [1,2,3],
//        [1,3,2],
//        [2,1,3],
//        [2,3,1],
//        [3,1,2],
//        [3,2,1]
//        ]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/permutations
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _46_全排列
{

//    这类题目都是同一类型的,用回溯算法!
//
//    其实回溯算法关键在于:不合适就退回上一步
//
//    然后通过约束条件, 减少时间复杂度.
//
//        大家可以从下面的解法找出一点感觉!
    public static List<List<Integer>> permute(int[] nums)
    {

        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(res, nums, new ArrayList<Integer>(), visited);
        return res;

    }

    private static  void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> tmp, boolean[] visited)
    {
        if (tmp.size() == nums.length) // 跳出条件
        {
            res.add(new ArrayList<>(tmp));
            return;
        }
        // 这种for循环 + 回溯的过程建议重点在于如何找回溯的条件
        // 以及递归往下走的条件是什么
        for (int i = 0; i < nums.length; i++)
        {
            if (visited[i]) continue;
            visited[i] = true;
            tmp.add(nums[i]);
            backtrack(res, nums, tmp, visited);
            visited[i] = false;/* 当回溯出来的时候，把元素设为没有访问 */
            tmp.remove(tmp.size() - 1);/* 这样就可以避免不断new出ArrayLi */
        }
    }
    
    private  static  void print(List<List<Integer>> lists)
    {
        for (int i = 0; i < lists.size(); i++)
        {
            for (int j = 0; j < lists.get(i).size(); j++)
            {
                System.out.print(lists.get(i).get(j)+" ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args)
    {
        int[] test = {1, 2, 3};
        List<List<Integer>> res = permute(test);
        print(res);
    }
}
