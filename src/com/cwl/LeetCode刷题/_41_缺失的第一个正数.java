package com.cwl.LeetCode刷题;
/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 21:50 2020-05-13
 */

/**
 * @ClassName: _41_缺失的第一个正数
 * @Description TODO
 * @Author:
 * @Date: 2020-05-13 21:50
 * @Version" 1.0
 */
//给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
//
//         
//
//        示例 1:
//
//        输入: [1,2,0]
//        输出: 3
//        示例 2:
//
//        输入: [3,4,-1,1]
//        输出: 2
//        示例 3:
//
//        输入: [7,8,9,11,12]
//        输出: 1
//         
//
//        提示：
//
//        你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/first-missing-positive
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

/*
思想：
遍历一次数组把大于等于1的和小于数组大小的值放到原数组对应位置，然后再遍历一次数组查当前下标是否和值对应，如果不对应那这个下标就是答案，否则遍历完都没出现那么答案就是数组长度加1。
 */

import java.util.Arrays;

/**
 *
 * O(n) 的算法要求 ， 而且又是数组问题，务必充分使用数组下标
 */
public class _41_缺失的第一个正数
{
    public static  int firstMissingPositive(int[] nums)
    {
//        第一个思路：拿num=1自增去找， 找得到 num+1，index置0， 跑完找不到 就是 num了 ，num达到length就不在自增找了

        // O(n^2)
        int num = 1;
        for(int index = 0 ; index < nums.length; index++){
            if(nums[index] == num){
                num++;
                index = -1;
            }
            if(index == nums.length-1)  break;
        }
        return num;

//        第二个思路：创建数组用于散列下标 范围内的数据，一次for做散列，二次for找第一个数据为0的下标，该下标的值就是 缺失的
//        时间复杂度 ，有元素的情况， 最多两个全遍历，最少一个全遍历+1； 那就是O(n)了把！！
//        int[] m = new int[nums.length+1];
//        for(int i = 0 ; i < nums.length; i++)
//            if(nums[i]>0&&nums[i] <= nums.length)
//                m[nums[i]] = 1;
//        for(int i = 1 ; i < m.length; i++)
//            if(m[i] == 0) return i;
//        return  m.length;
    }

    public static void main(String[] args)
    {
        int[] test1 = {1,2,0};
        System.out.println(firstMissingPositive(test1));


    }
}
