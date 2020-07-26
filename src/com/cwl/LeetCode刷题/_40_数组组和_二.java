package com.cwl.LeetCode刷题;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 21:17 2020-05-13
 */

import java.util.*;

/**
 *
 * @ClassName: _40_数组组和_二
 * @Description TODO
 * @Author:
 * @Date: 2020-05-13 21:17 
 * @Version" 1.0
 */

//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
//        candidates 中的每个数字在每个组合中只能使用一次。
//
//        说明：
//
//        所有数字（包括目标数）都是正整数。
//        解集不能包含重复的组合。 
//        示例 1:
//
//        输入: candidates = [10,1,2,7,6,1,5], target = 8,
//        所求解集为:
//        [
//        [1, 7],
//        [1, 2, 5],
//        [2, 6],
//        [1, 1, 6]
//        ]
//        示例 2:
//
//        输入: candidates = [2,5,2,1,2], target = 5,
//        所求解集为:
//        [
//          [1,2,2],
//          [5]
//        ]

/* 重点就是使用的数字不可重复 */
public class _40_数组组和_二
{
    public static List<List<Integer>> combinationSum2(int[] candidates, int target)
    {
        List<List<Integer>> result  = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        find(candidates,target,result,list,0);
//        var set = new HashSet<>(result);
//        List<List<Integer>> lists = new ArrayList<>(set);
        return  result;
    }
    
    private static void find(int[] candidates,int target,List<List<Integer>> listAll,List<Integer> list,int index)
    {
        if(target == 0)
        {
            listAll.add(list);
            return;
        }
        if(target < candidates[0])
        {
            return;
        }
        for (int i = index; i < candidates.length && candidates[i] <= target; i++)
        {
            if(i>index&&candidates[i] == candidates[i-1])
            {
                continue;
            }
            List<Integer> listTmp = new ArrayList<>(list);
            listTmp.add(candidates[i]);
            find(candidates,target-candidates[i],listAll,listTmp,i+1);
            
        }
    }
    
    private static void print(List<List<Integer>> listAll)
    {
        for (int i = 0; i < listAll.size(); i++)
        {
            for (int j = 0; j < listAll.get(i).size(); j++)
            {
                System.out.print(listAll.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        int [] test = {10,1,2,7,6,1,5};
        int [] test1 = {2,5,2,1,2};
        int target1 = 5;
        int target = 8;
        List<List<Integer>> res = combinationSum2(test, target);
        List<List<Integer>> res1 = combinationSum2(test1, target1);
        print(res);
        System.out.println("---------------- 我是分隔符 ----------------");
        print(res1);

    }
}
