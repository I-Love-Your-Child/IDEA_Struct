package com.cwl.Tes;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 23:23 2020-05-25
 */

/**
 * @ClassName: 选择矩阵
 * @Description TODO
 * @Author:
 * @Date: 2020-05-25 23:23
 * @Version" 1.0
 */
public class 选择矩阵
{
    public static void rotate(int[][] matrix)
    {
        int len = matrix.length;
        //每次处理最外层的一圈，剥洋葱的方式
        int a;
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++)
        {
            for (int j = i; j < n - i - 1; j++)
            {
                a = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = a;
            }
        }
    }
}
