package com.cwl.LeetCode刷题;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 04:23 2020-05-18
 */

/**
 * @ClassName: _74_搜索二维矩阵
 * @Description TODO
 * @Author:
 * @Date: 2020-05-18 04:23
 * @Version" 1.0
 */

//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
//
//        每行中的整数从左到右按升序排列。
//        每行的第一个整数大于前一行的最后一个整数。
//        示例 1:
//
//        输入:
//        matrix = [
//        [1,   3,  5,  7],
//        [10, 11, 16, 20],
//        [23, 30, 34, 50]
//        ]
//        target = 3
//        输出: true
//        示例 2:
//
//        输入:
//        matrix = [
//        [1,   3,  5,  7],
//        [10, 11, 16, 20],
//        [23, 30, 34, 50]
//        ]
//        target = 13
//        输出: false
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/search-a-2d-matrix
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _74_搜索二维矩阵
{
    /*
    这道题的关键点在于利用矩阵升序的特性，需要选择合适的切入点与目标值相比较以缩小数据返围，
    很明显如果选择左上角或右下角当做切入点并不能起到只能分别排除一个选项，
    而如果选择右上角或者左下角进行比较即可起到更明显的效果。
     */
    public static boolean searchMatrix(int[][] matrix, int target)
    {
        if (matrix.length == 0)
            return false;
        int row = 0, col = matrix[0].length - 1; //从左下角出发
        while (row < matrix.length && col >= 0)
        {
            if (matrix[row][col] < target) //同时进行横向或者是竖向扫描
                row++;
            else if (matrix[row][col] > target)
                col--;
            else
                return true;
        }
        return false;
    }

    public static void main(String[] args)
    {
        int[][] test = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        int target = 3;
        System.out.println(searchMatrix(test, target));
    }
}
