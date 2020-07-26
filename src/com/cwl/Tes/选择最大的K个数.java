package com.cwl.Tes;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 00:04 2020-05-20
 */

import java.util.PriorityQueue;

/**
 *
 * @ClassName: 选择最大的K个数
 * @Description TODO
 * @Author:
 * @Date: 2020-05-20 00:04 
 * @Version" 1.0
 */
public class 选择最大的K个数
{
    /* 最大的k个数，返回的实际上是一个数组，用最大堆或者是最小堆。用if语句保持堆的数量 */
    public static void main(String[] args)
    {
        /* 默认是自然排序的堆就可以了 */
        /* 需要采用最小堆哦 */
        /* 这个是最小堆，千万别搞反了 */
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->a-b);
        int [] test = {7,5,3,2,10};
        int k = 4;
        for (int i : test)
        {
            if(queue.size() < k)
            {
                queue.add(i);
            }else if(i>queue.peek())
            {
                queue.poll(); /* 每次剔除的都是最小的元素，那么一轮遍历下来剔除掉最小的n-k个元素，就是最大的k个元素了 */
                queue.add(i);
            }
        }
        System.out.println(queue.size());
        System.out.println("---------------- 我是分隔符 ----------------");
        int [] result = new int [k];
        for (int i = 0; i< k && !queue.isEmpty(); i++)
        {
            result[i] = queue.poll();
        }
        for (int i : result)
        {
            System.out.println(i);
        }
        
        System.out.println("---------------- 我是分隔符 ----------------");
        PriorityQueue<Integer> res = new PriorityQueue<>();//实际上是最小堆哦
        res.add(10);
        res.add(9);
        System.out.println(res.peek());
        
    }
}
