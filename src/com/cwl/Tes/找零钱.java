package com.cwl.Tes;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 17:30 2020-05-22
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @ClassName: 找零钱
 * @Description TODO
 * @Author:
 * @Date: 2020-05-22 17:30
 * @Version" 1.0
 */
public class 找零钱
{
    private static int find(int[] nums, int target)
    {
        List<List<Integer>> listAll = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int tmp = 0;
        backTrace(nums, target, listAll, list, tmp);
        for (int i = 0; i < listAll.size(); i++)
        {
            for (int j = 0; j < listAll.get(i).size(); j++)
            {
                System.out.print(listAll.get(i).get(j)+" ");
            }
            System.out.println();
        }
        HashSet<List<Integer>> res = new HashSet<>(listAll);
        return res.size();
    }
    /**
     *
     * 其实我们大部分的时候都是使用老式的键盘最好用了，这个是真的
     *
     */

    private static void backTrace(int[] nums, int target, List<List<Integer>> listAll, List<Integer> list, int tmp)
    {
        if (tmp == target)
        {
            list.sort((a1,b1) ->  a1-b1);
            listAll.add(new ArrayList<>(list));  //可以在最后添加的时候new ArrayList<>();
            list.forEach(System.out::println);
            System.out.println("---------------- 我是分隔符 ----------------");
            return;

        } else if (tmp > target)
        {
            return;
        }

        for (int i = 0; i < nums.length; i++)
        {
            list.add(nums[i]);
            tmp += nums[i];// 进口
            backTrace(nums, target, listAll, list, tmp);  //回溯
            tmp -= nums[i]; // 出口
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args)
    {
        int[] test = {1, 2, 5, 10};
        System.out.println("结果："+find(test, 5));
    }
}
