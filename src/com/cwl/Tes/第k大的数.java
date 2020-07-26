package com.cwl.Tes;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 00:44 2020-05-20
 */

/**
 *
 * @ClassName: 第k大的数
 * ®@Description TODO
 * @Author:
 * @Date: 2020-05-20 00:44 
 * @Version" 1.0
 */
public class 第k大的数
{
    /* 分治法，利用快速排序的思想，每一次把数组分为较大和较小的两部分 */
    
    //https://www.cnblogs.com/kyoner/p/10465633.html
    
//    private  static int  quick(int[]nums,int k)
//    {
//        if(k>nums.length)
//        {
//            return -1;
//        }
//
//        int p = Partition(nums,0,nums.length-1);
//        while (true)
//        {
//            if(k == p+1)
//            {
//                break;
//            }
//            else if(p+1 > k)
//            {
//                p = Partition(nums,0,p-1);
//            }
//            else
//            {
//                p = Partition(nums,p+1,nums.length-1);
//            }
//        }
//        return nums[p];
//    }
//
//    private  static int Partition(int [] nums ,int left, int right)
//    {
//        int privot = nums[left];
//        while(left<right)
//        {
//           while(left<right && nums[right]>=privot)
//           {
//              right--;
//           }
//           if(left<right)
//           {
//               nums[left++] = nums[right--];
//           }
//           while (left<right && nums[left]<=privot)
//           {
//               left++;
//           }
//           if(left<right)
//           {
//               nums[right--]=nums[left++];
//           }
//
//        }
//        nums[left] = privot;
//        return left;
//
//    }
//
    public static void main(String[] args)
    {
        int []nums = {1,2,3,4,5,7,6,111,10};
        System.out.println(quick(nums,9));
    }

    static  int quick(int[]nums,int k)
    {
      if(k >nums.length)
      {
          return -1;
      }
        int p = Partition(nums,0,nums.length-1);
        while (true)
      {
          if(k == p+1)
          {
              break;
          }else if(k < p+1) //左边范围大
          {
              p = Partition(nums,0,p-1);
          }else {// 右边范围大
              p = Partition(nums,p+1,nums.length-1);
          }
      }
        return nums[p];
    }

    static  int Partition(int[] nums,int left, int right)
    {
        int pivot = nums[left];
        while(left<right)
        {
           while (left<right && nums[right] >= pivot)
               right--;
           if(left<right)
           {
               nums[left++] = nums[right--];
           }
           while (left<right && nums[left] <= pivot)
               left++;
           if(left<right)
           {
               nums[right--] = nums[left++];
           }
        }
        nums[left] = pivot;

        return left;

    }

    
}
