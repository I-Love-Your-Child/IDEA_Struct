package com.cwl.LeetCode刷题;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 13:19 2020-05-17
 */

import java.util.ArrayList;
import java.util.Collections;

/**
 * @ClassName: _56_合并区间
 * @Description TODO
 * @Author:
 * @Date: 2020-05-17 13:19
 * @Version" 1.0
 */

//给出一个区间的集合，请合并所有重叠的区间。
//
//        示例 1:
//
//        输入: [[1,3],[2,6],[8,10],[15,18]]
//        输出: [[1,6],[8,10],[15,18]]
//        解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//        示例 2:
//
//        输入: [[1,4],[4,5]]
//        输出: [[1,5]]
//        解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/merge-intervals
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _56_合并区间
{
    /*
    搜西安需要对左端区间进行排序
     */

    public static int[][] merge(int[][] intervals)
    {
        int len = intervals.length;
        if (len < 2) return intervals;

        int cnt = 0; // 合并次数
        for (int i = 0; i < len - 1; i++)
        {
            for (int j = i + 1; j < len; j++)
            {
                if (intervals[i][0] <= intervals[j][1] && intervals[i][1] >= intervals[j][0])
                {
                    intervals[j][0] = Math.min(intervals[j][0], intervals[i][0]);
                    intervals[j][1] = Math.max(intervals[j][1], intervals[i][1]);
                    intervals[i] = null; // 清空前者
                    cnt++;
                    break;
                }
            }
        }

        int[][] res = new int[len - cnt][2]; // len - cnt 合并后个数
        int ri = 0;
        for (int[] pair : intervals)
        {
            if (pair != null) res[ri++] = pair;
        }
        return res;
    }

    public static void main(String[] args)
    {
        int[][] test = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] res = merge(test);
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
