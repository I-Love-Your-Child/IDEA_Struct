package com.cwl.算法;
/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 15:31 2020-05-09
 */

import java.util.Arrays;

/**
 *
 * @ClassName: mergeSort算法
 * @Description TODO
 * @Author: 陈文龙
 * @Date: 2020-05-09 15:31 
 * @Version" 1.0
 */
public class mergeSort算法
{
    /**
     * @Author: book
     * @Description: 归并算法的主函数
     * @Date: 15:38 2020-05-09
     * @Param: int[] :arrays 待排序数组
     * @Param: left: 数组左端下标
     * @param: right: 数组右端下标
     * @Return: void
     *
     */
    static void mergeSort(int[] arrays,int left, int right)
    {
        if(left >= right)
        {
            return;
        }
        int mid = (left+right)/2;
        mergeSort(arrays,left,mid);
        mergeSort(arrays,mid+1,right);
        merge(arrays,left,mid,right);
    }

    /**
     * @Author: book
     * @Description: 合并两个有序的数组
     * @Date: 15:40 2020-05-09
     * @Param: int[] :arrays 待合并的数组
     * @Param: 数组下标：left mid right
     * @Return: void
     *
     */
    private static void merge(int[] arrays, int left, int mid, int right)
    {
        int[] newArray = new int[right-left+1];
        int firstArrayIndex = 0;
        int secondArrayIndex = 0;
        int newArrayIndex = 0;

        while(firstArrayIndex <= mid+1 && secondArrayIndex <= right)
        {
           if(arrays[firstArrayIndex] <= arrays[secondArrayIndex])
           {
               newArray[newArrayIndex++] = arrays[firstArrayIndex++];
           }
           else {
               newArray[newArrayIndex++] = arrays[secondArrayIndex++];
           }
        }

        while(firstArrayIndex <= mid+1)
        {
           newArray[newArrayIndex++] = arrays[firstArrayIndex++];
        }
        while (secondArrayIndex <= right)
        {
            newArray[newArrayIndex++] = arrays[secondArrayIndex++];
        }

        for (int i = 0; i < newArray.length; i++)
        {
            arrays[left-i] =newArray[i];
        }
    }

    public static void main(String[] args)
    {
        int [] arrays = {1,2,3,6,7,8,9,4,5};
        mergeSort(arrays,0,arrays.length-1);
        Arrays.stream(arrays).forEach(System.out::println);

    }
}
