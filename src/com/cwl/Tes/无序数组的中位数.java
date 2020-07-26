package com.cwl.Tes;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 01:12 2020-05-20
 */

/**
 *
 * @ClassName: 无序数组的中位数
 * @Description TODO
 * @Author:
 * @Date: 2020-05-20 01:12 
 * @Version" 1.0
 */

/* 这个就是第k大个数的改编的版本 */
public class 无序数组的中位数
{
    
    private static int findTopK(int[] nums,int k)
    {
        if (k>nums.length)
        {
            return -1;
        }
        
        int p = Partition(nums,0,nums.length-1);
        
        while (true)
        {
            if(k == p+1)
            {
                break;
            }
            else if(p+1 < k)
            {
                p = Partition(nums,p+1,nums.length-1);
            }
            else {
                p = Partition(nums,0,p-1);
            }
        }
        return nums[p];
    }
    
    private static int Partition(int[]nums, int left,int right)
    {
        int pivot = nums[left];
        while (left<right)
        {
            while (left<right&&nums[right]>=pivot)
                right--;
            if(left<right)
            {
                nums[left++]=nums[right--];
            }
            while (left<right && nums[left]<=pivot)
                left++;
            if(left<right)
            {
                nums[right--]=nums[left++];
            }
        }
        nums[left] = pivot;
        return left;
    }
    public static void main(String[] args)
    {
        int [] res ={1,2,3,4,5,6};
        if(res.length%2 == 0) //偶数位
        {
            System.out.println(    (findTopK(res,res.length/2+1) + findTopK(res,res.length/2) ) /(2*1.0)  );
        }
        else
        {
            System.out.println(findTopK(res,res.length/2+1));

        }
    }
}
