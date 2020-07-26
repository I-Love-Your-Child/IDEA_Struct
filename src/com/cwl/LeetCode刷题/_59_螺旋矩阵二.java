package com.cwl.LeetCode刷题;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 14:07 2020-05-17
 */

/**
 * @ClassName: _59_螺旋矩阵二
 * @Description TODO
 * @Author:
 * @Date: 2020-05-17 14:07
 * @Version" 1.0
 */


public class _59_螺旋矩阵二
{
    public static int[][] generateMatrix(int n)
    {
        int[][] arr = new int[n][n];
        int c = 1, j = 0;
        while (c <= n * n)
        {

            for (int i = j; i < n - j; i++)
                arr[j][i] = c++;
            for (int i = j + 1; i < n - j; i++)
                arr[i][n - j - 1] = c++;
            for (int i = n - j - 2; i >= j; i--)
                arr[n - j - 1][i] = c++;
            for (int i = n - j - 2; i > j; i--)
                arr[i][j] = c++;

            j++;
        }

        return arr;
    }


    public static void main(String[] args)
    {
//        int[][] 选择最大的K个数 = {
//                {1, 2, 3},
//                {8, 9, 4},
//                {7, 6, 5}
//        };
        int[][] res = generateMatrix(3);
        for (int[] x :
                res)
        {
            for (int y :
                    x)
            {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }
}
