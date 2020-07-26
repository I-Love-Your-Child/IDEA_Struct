package com.cwl.Tes;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 15:33 2020-05-20
 */

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @ClassName: t
 * @Description TODO
 * @Author:
 * @Date: 2020-05-20 15:33 
 * @Version" 1.0
 */
public class t
{
    public static List<List<Integer>> permute(int[] nums)
    {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited =  new boolean[nums.length];

        backtrack(res,nums,new ArrayList<Integer>(),visited); // 回溯
        return  res;
    }

    private static void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> tmp, boolean[] visited)
    {
        if(tmp.size()==nums.length) //达到了全排列的数量，就退出
        {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++)
        {
            if(visited[i] == true) // 访问过的节点局跳过
            {
                continue;
            }
            visited[i] = true;  // 入口
            backtrack(res,nums,tmp,visited);  // 回溯
            visited[i] = false; //出口
            tmp.remove(tmp.size() -1); // 回溯回来，就删除回溯的那个元素
        }
    }

    public static void main(String[] args)
    {

    }
}
