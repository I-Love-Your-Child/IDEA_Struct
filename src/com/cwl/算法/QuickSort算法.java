package com.cwl.算法;
/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 15:22 2020-05-09
 */

import java.util.Arrays;

/**
 *
 * @ClassName: QuickSort算法
 * @Description TODO
 * @Author:
 * @Date: 2020-05-09 15:22 
 * @Version" 1.0
 */
public class QuickSort算法
{
    /*
    三段式的QuickSort算法
     */

    /**
     * @Author: book
     * @Description: 快速排序主函数
     * @Date: 15:30 2020-05-09
     * @Param: [数组arrays, 起始坐标left, 结束坐标right]
     * @Return: void
     *
     */
    public static void quickSort(int[] arrays, int left, int right)
    {
        if(left>=right)
        {
            return;
        }
        int p = partition(arrays,left,right);
        quickSort(arrays,left,p-1);
        quickSort(arrays,p+1,right);
    }
    /**
     * @Author: book
     * @Description: 快速排序Partion函数
     * @Date: 15:30 2020-05-09
     * @Param: [arrays, left, right]
     * @Return: int 返回的是哨兵的做包
     *
     */
    private static int partition(int[] arrays, int left, int right)
    {
        int pivot = arrays[left];
        while(left < right)
        {
           while (left < right && arrays[right] >= pivot)
           {
               right--;
           }
           if(left < right)
           {
               arrays[left] = arrays[right];
           }
           while (left < right && arrays[left] <= pivot)
           {
               left++;
           }
           if(left<right)
           {
               arrays[right] = arrays[left];
           }
        }
        arrays[left] = pivot;/* 哨兵归位 */
        return left; /* left == right */
    }

    public static void main(String[] args)
    {
        int [] arrays = {1,2,3,4,7,8,9,5,6};
        quickSort(arrays,0,arrays.length-1);
        Arrays.stream(arrays).forEach(System.out::println);

    }
}
