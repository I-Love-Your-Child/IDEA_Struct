package com.cwl.LeetCode刷题;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 21:26 2020-05-16
 */

/**
 * @ClassName: _53_最大子序和
 * @Description TODO
 * @Author:
 * @Date: 2020-05-16 21:26
 * @Version" 1.0
 */
public class _53_最大子序和
{
//    贪心算法
    /*  核心思想：
    若当前指针所指元素之前的和小于 0, 则丢弃当前元素之前的数列
    */
//    当前值：4 之前和：-2 当前和：4 最大和：4
    /*
    所以贪心算法需要 三个 额外变量， 当前和， 之前和， 最大和
     */
    public static int maxSubArray(int[] nums)
    {
        int res = nums[0];
        int sum = 0;
        for (int num : nums)
        {
            if (sum > 0)
                sum += num;
            else
                sum = num;
            res = Math.max(res, sum);
        }
        return res;
    }

    public static void main(String[] args)
    {
        int[] test = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(test));
    }

}
