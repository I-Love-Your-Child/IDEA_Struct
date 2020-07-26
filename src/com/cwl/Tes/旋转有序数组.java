package com.cwl.Tes;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 12:58 2020-05-29
 */

/**
 * @ClassName: 旋转有序数组
 * @Description TODO
 * @Author:
 * @Date: 2020-05-29 12:58
 * @Version" 1.0
 */
public class 旋转有序数组
{
    public static int rotatedBinarySearch(int[] array, int target)
    {
        if(array==null || array.length ==0)
        {
            return  -1;
        }
        int left =0, right = array.length-1;
        while (left<=right)
        {
            int mid = left+(right-left)/2;
            if(array[mid]==target)
            {
                return mid;
            }
            if(array[mid]>=array[left])
            {
                if(array[mid]>target && array[left]<=target)
                {
                    right = mid-1;
                }
                else {
                    left = mid +1;
                }
            }else
            {
                if(array[mid]<target && target<=array[right])
                {
                    left = mid +1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int[] test = {9, 10, 11, 12, 13, 1, 3, 4, 5, 8};
        System.out.println(rotatedBinarySearch(test, 12));
    }
}
