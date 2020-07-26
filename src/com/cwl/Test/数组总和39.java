package com.cwl.Test;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 20:52 2020-05-13
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: 数组总和39
 * @Description TODO
 * @Author:
 * @Date: 2020-05-13 20:52
 * @Version" 1.0
 */
public class 数组总和39
{
    public static List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        //递归是一条路走到黑，然后回退一步，另寻它路
        //通过for循环+ 递归的形式可以实现所有路径的遍历

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        find(result,list,candidates,0,target);
        return result;
    }

    private  static  void find(List<List<Integer>> listAll,List<Integer> list,int[] candidates,int index,int target)
    {
        if(target == 0)
        {
            listAll.add(list);
            return;
        }
        if(target<candidates[0])
        {
            return;
        }

        for (int i = index; i < candidates.length && candidates[i] <= target ; i++)
        {
            // 拷贝一份，不影响下一次的递归
            List<Integer> listTmp = new ArrayList<>(list);
            listTmp.add(candidates[i]);
            find(listAll,listTmp,candidates,i,target - candidates[i]);
        }

    }

    public static  void print(List<List<Integer>> test)
    {
        for (int i = 0; i < test.size(); i++)
        {
            for (int j = 0; j < test.get(i).size(); j++)
            {
                System.out.print(test.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args)
    {
        int [] test = {8,7,4,3};
        int [] test1 = {2,3,5};
        int target = 11;
        int target1 = 8;
        List<List<Integer>> res = new ArrayList<>();
        res = combinationSum(test,target);
        print(res);

    }
}
