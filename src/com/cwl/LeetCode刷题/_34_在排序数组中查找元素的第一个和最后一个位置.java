package com.cwl.LeetCode刷题;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 16:39 2020-05-11
 */

import java.util.Arrays;

/**
 * @ClassName: _34_在排序数组中查找元素的第一个和最后一个位置
 * @Description 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * @Author:
 * @Date: 2020-05-11 16:39
 * @Version" 1.0
 */
public class _34_在排序数组中查找元素的第一个和最后一个位置
{
    public static  int[] searchRange(int[] nums, int target)
    {
        int i = Arrays.binarySearch(nums, target);
        if (i < 0) return new int[]{-1, -1};
        int begin = i;
        int end = i;
        while (begin - 1 >= 0 && nums[begin - 1] == target)
        {
            begin--;
        }
        while (end + 1 < nums.length && nums[end + 1] == target)
        {
            end++;
        }
        return new int[]{begin, end};
    }

    public static void main(String[] args)
    {
        int[]nums = {5,7,7,8,8,10};
        int[]res = searchRange(nums,8);
        System.out.println(res[0]+" "+res[1]);
        res = searchRange(nums,6);
        System.out.println(res[0]+" "+res[1]);
    }
}
