package com.cwl.Tes;
/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 19:56 2020-05-12
 */

/**
 * @ClassName: Main
 * @Description TODO
 * @Author:
 * @Date: 2020-05-12 19:56
 * @Version" 1.0
 */
public class Main
{
    public static int findIndex(int[] arrays, int target)
    {
        if (arrays.length == 0)
        {
            return -1;
        } else if (arrays.length == 1)
        {
            return arrays[0] == target ? 0 : -1;
        }


        int left = 0;
        int right = arrays.length - 1;
        while (left <= right)
        {
            int mid = (left + right) / 2;

            if (arrays[mid] == target)
            {
                return mid;
            } else if (arrays[mid] < arrays[right])
            {
                if (arrays[mid] < target && target <= arrays[right])
                {
                    left = mid + 1;
                } else
                {
                    right = mid - 1;
                }
            } else
            {
                if (arrays[left] <= target && target < arrays[mid])
                {
                    right = mid - 1;
                } else
                {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int[] testArrays = {4, 5, 6, 1, 2, 3};

        System.out.println(findIndex((testArrays), 1));
    }
}
