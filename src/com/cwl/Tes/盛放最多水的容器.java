package com.cwl.Tes;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 23:16 2020-05-25
 */

/**
 *
 * @ClassName: 盛放最多水的容器
 * @Description TODO
 * @Author:
 * @Date: 2020-05-25 23:16 
 * @Version" 1.0
 */
public class 盛放最多水的容器
{
    /*
    使用双指针的原因是根据这个问题的特点，存水的高度取决于两边较短的那个内壁的高度。
使用指针对撞的方式不会错过最优解。
经验：双指针、滑动窗口的问题，一般先从暴力枚举开始思考，然后更改枚举的顺序，以达到剪枝加快计算的效果。
     */
    public static int maxArea(int[] height)
    {
        int len = height.length;
        if(len < 2)
        {
            return  0;
        }
        /* 双指针 */
        int left = 0;
        int right = len - 1;
        int res = 0;
        while(left < right)
        {
           int minHeight = Math.min(height[left],height[right]);
           res = Math.max(res,minHeight * (right-left));
           if(height[left] == minHeight)
           {
               left++;
           }else if(height[right] == minHeight)
           {
               right--;
           }
        }
        return res;
    }

    public static void main(String[] args)
    {
        int []test = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(test));
    }
}
