package com.cwl.LeetCode刷题;
/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 01:30 2020-05-15
 */

import java.util.*;

/**
 * @ClassName: _47_全排列二
 * @Description TODO
 * @Author:
 * @Date: 2020-05-15 01:30
 * @Version" 1.0
 */
//
//给定一个可包含重复数字的序列，返回所有不重复的全排列。
//
//        示例:
//
//        输入: [1,1,2]
//        输出:
//        [
//        [1,1,2],
//        [1,2,1],
//        [2,1,1]
//        ]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/permutations-ii
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _47_全排列二
{
    static List<List<Integer>> ans = new ArrayList<>();

    public static List<List<Integer>> permuteUnique(int[] nums) {
        dfs(nums,0);
        return ans;
    }

    private static  void dfs(int[] nums,int cur) {
        if (cur == nums.length) {
            List<Integer> line = new ArrayList<>();
            for (int i : nums) {
                line.add(i);
            }
            ans.add(line);
        } else {
            for (int i = cur;i < nums.length;i++) {
                if (canSwap(nums,cur,i)) {
                    swap(nums,cur,i);
                    dfs(nums,cur + 1);
                    swap(nums,cur,i);
                }
            }
        }
    }

    private static  boolean canSwap(int nums[],int begin,int end) {
        for (int i = begin;i < end;i++) {
            if (nums[i] == nums[end]) {
                return false;
            }
        }

        return true;
    }

    private static void swap(int nums[],int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void print(List<List<Integer>> lists)
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
//    思路：两种思路，第一种是直接dfs全排列然后使用set暴力去重，效率较低；第二种是在dfs全排列搜索交换前先判断一下是否已经交换过
    public static void main(String[] args)
    {
        int[] test = {1,2147483647,2147483647,2147483647};
        List<List<Integer>> res = permuteUnique(test);
        print(res);
    }
}
