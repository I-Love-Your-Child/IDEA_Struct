package com.cwl.Tes;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 10:53 2020-05-27
 */

/**
 *
 * @ClassName: 最大子序列he
 * @Description TODO
 * @Author:
 * @Date: 2020-05-27 10:53 
 * @Version" 1.0
 */
public class 最大子序列he
{

    static int max(int [] nums)
    {
        int res = 0;
        for(int i=0;i<nums.length;++i)
        {
            if(i==0)
            {
                res = nums[i];
            }
            else if(res<0 && nums[i] <= res)
            {
                res = nums[i];
            }else if(res>0 && nums[i]>=0)
            {
                res+=nums[i];
            }
        }
        return res;
    }
    public static void main(String[] args)
    {
        int [] test = {1,2,3,4,5,-4,6,-10};
        System.out.println(max(test));
    }
}
