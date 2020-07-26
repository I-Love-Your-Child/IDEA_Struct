package com.cwl.LeetCode刷题;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 13:35 2020-05-17
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: _57_插入区间
 * @Description TODO
 * @Author:
 * @Date: 2020-05-17 13:35
 * @Version" 1.0
 */

//给出一个无重叠的 ，按照区间起始端点排序的区间列表。
//
//        在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
//
//        示例 1:
//
//        输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
//        输出: [[1,5],[6,9]]
//        示例 2:
//
//        输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//        输出: [[1,2],[3,10],[12,16]]
//        解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/insert-interval
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _57_插入区间
{
    public static  int[][] insert(int[][] intervals, int[] newInterval)
    {
        ArrayList<int[]> listAll = new ArrayList<>();
        for (int[] x :
                intervals)
        {
            listAll.add(x);
        }
        listAll.add(newInterval);
        Collections.sort(listAll,(a,b)->a[0]-b[0]);
        for (int i = 0; i < listAll.size()-1; i++)
        {
            if(listAll.get(i)[1]<listAll.get(i+1)[0])
            {
                continue;
            }else
            {
                if(listAll.get(i)[1]<listAll.get(i+1)[1])
                {
                    listAll.get(i+1)[0]=listAll.get(i)[0];
                    listAll.get(i)[0]=Integer.MAX_VALUE;
                }
                else
                {
                    listAll.get(i+1)[0]=listAll.get(i)[0];
                    listAll.get(i+1)[1]=listAll.get(i)[1];
                    listAll.get(i)[0]=Integer.MAX_VALUE;
                }


            }
        }
        List<int[]> res1 = listAll.stream().filter(a -> a[0] != Integer.MAX_VALUE).collect(Collectors.toList());
        int[][]res = new int[res1.size()][2];
        for (int i = 0; i < res1.size(); i++)
        {
            res[i] = res1.get(i);
        }
        return res;
    }

    private  static void print(int[][]res)
    {
        for (int[] x :
                res)
        {
            for (int y :
                    x)
            {
                System.out.print(y+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
//        int[][] 选择最大的K个数 = {{1,3},{6,9}};
//        int [] inse = {2,5};
//        print(insert(选择最大的K个数,inse));
//        System.out.println();
        int[][]test1 = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] inse1={4,8};
        print(insert(test1,inse1));
    }
}
