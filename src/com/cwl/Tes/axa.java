package com.cwl.Tes;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 16:00 2020-05-26
 */

import java.util.*;

/**
 *
 * @ClassName: axa
 * @Description TODO
 * @Author:
 * @Date: 2020-05-26 16:00 
 * @Version" 1.0
 */
public class axa
{
    static int min = Integer.MAX_VALUE;
    public static  int coinChange(int[] coins, int amount)
    {
        Integer[] coins1 = Arrays.stream(coins).boxed().toArray(Integer[]::new);
        Arrays.sort(coins1, Collections.reverseOrder() );
        coins = Arrays.stream(coins1).mapToInt(Integer::valueOf).toArray();
        List<List<Integer>> listAll = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
//        for (int x : coins)
//        {
//                System.out.println(x);
//        }
        find(listAll,list,coins,0,amount);
        if(min == Integer.MAX_VALUE) return -1;
        for (int i = 0; i < listAll.size(); i++)
        {
            for (int j = 0; j < listAll.get(i).size(); j++)
            {
                System.out.print(listAll.get(i).get(j)+" ");
            }
            System.out.println();
        }
        return min;
    }

    //剪枝！！剪枝

    public static  void find(List<List<Integer>>listAll,List<Integer> list , int[] coins,int index,int amount)
    {
        if(list.size() > min) //剪枝
        {
            return;
        }
        if(amount == 0)
        {
            if(list.size() < min)
            {
                min = list.size();
                listAll.add(new LinkedList<>(list));
                return;
            }else
            {
                return;
            }

        }
        if(amount < coins[coins.length-1])
        {
            return;
        }
        for(int i = index; i< coins.length ;++i)
        {
            list.add(coins[i]); //入口前
            //入口
            find(listAll,list,coins,i,amount-coins[i]);
            //出口
            list.remove(list.size()-1); //出口后

        }
    }

    public static void main(String[] args)
    {
        System.out.println(coinChange(new int[]{2},3));
    }
}
