package com.cwl.LeetCode刷题;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 23:31 2020-05-15
 */

import java.util.Arrays;

/**
 * @ClassName: _48_旋转图像
 * @Description TODO
 * @Author:
 * @Date: 2020-05-15 23:31
 * @Version" 1.0
 */
public class _48_旋转图像
{
    public static void rotate(int[][] matrix)
    {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
        {
            return;
        }

        int col = matrix[0].length - 1;
        int row = matrix.length - 1;

        int colF = col;
        int rowF = row;

        for (int r = 0; r < rowF; r++)
        {
            for (int c = r; c < colF; c++)
            {
                int x1 = r;
                int y1 = c;

                int x2 = c;
                int y2 = col - r;

                int x3 = row - r;
                int y3 = col - c;

                int x4 = row - c;
                int y4 = r;

                swap(matrix, x1, y1, x2, y2);
                swap(matrix, x1, y1, x3, y3);
                swap(matrix, x1, y1, x4, y4);
            }
            rowF--;
            colF--;
        }


    }

    public static void swap(int[][] matrix, int x1, int y1, int x2, int y2)
    {
        int temp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = temp;
    }

    private static void  print(int[][] martix)
    {
        for (int i = 0; i < martix.length; i++)
        {
            for (int j = 0; j < martix[i].length; j++)
            {
                if(j==0)
                {
                    System.out.print("["+martix[i][j]+",");
                }
                else if(j==martix[i].length-1)
                {
                    System.out.println(martix[i][j]+"]");
                }
                else {
                    System.out.print(martix[i][j]+",");

                }
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args)
    {
        int[][] test = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        int[][] test1 = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        rotate(test);
        rotate(test1);
        print(test);
        System.out.println("---------------- 我是分隔符 ----------------");
        print(test1);

    }

    /* 扣了四个边界出来.四个边界点交换. 每遍历一层.就往里缩一个矩阵. */
    /** 输出：
     * [7,4,1]
     *
     * [8,5,2]
     *
     * [9,6,3]
     *
     * ---------------- 我是分隔符 ----------------
     * [15,13,2,5]
     *
     * [14,3,4,1]
     *
     * [12,6,8,9]
     *
     * [16,7,10,11]
     */
}
