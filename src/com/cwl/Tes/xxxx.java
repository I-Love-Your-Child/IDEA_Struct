package com.cwl.Tes;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 16:45 2020-05-26
 */

/**
 *
 * @ClassName: xxxx
 * @Description TODO
 * @Author:
 * @Date: 2020-05-26 16:45 
 * @Version" 1.0
 */
public class xxxx
{
    public static void main(String[] args)
    {
        int []array = {10,9,8,7,6,5,4,3,2,1,0};

        // 这种二分头尾的题目下次直接秒了。不要再犹豫了。


        int left = 0;
        int right = array.length-1;
        while (left<right)
        {
            array[left]^=array[right];
            array[right]^=array[left];
            array[left]^=array[right];
            left++;
            right--;
        }
        for (int i : array)
        {
            System.out.println(i);
        }
    }
}
