package com.cwl.Test;
/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 13:39 2020-05-10
 */

/**
 * @ClassName: Prim算法测试
 * @Description TODO
 * @Author:
 * @Date: 2020-05-10 13:39
 * @Version" 1.0
 */
public class Prim算法测试
{
    private static char[] nodeName = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};//假设就7个节点
    private static final int INF = Integer.MAX_VALUE; //21亿  ====> 2147483647

    public static  void prim(int[][]maps,int start)
    {
        int num = maps[0].length;//节点数量
        char[] resultNode = new char[num];
        int [] weight  = new int[num];
        for (int i = 0; i < num; i++)
        {
            weight[i] = maps[start][i];//一开始权值数组初始化成起点到其他点的权重
        }
        weight[start] = 0; // ==0 可以表示已访问。
        int index = 0;
        resultNode[index++] = nodeName[start] ; /* 默认的起点为start节点 */
        /**
         *
         * 有了结果集合之后，你在计算它的MST的值就是直接遍历一下即可。
         */
        for (int i = 0; i < num; i++)
        {
            if(i == start)
            {
                continue; /* 如果是起点的话直接跳过 */
            }
//            maps[start][i] /* 起点到其他点的距离。 */
            int min = INF;
            int j = 0;
            int indexMin = 0;
            for (; j < num; j++)
            {
                if(weight[j] !=0 && weight[j] < min) //节点没有被访问同时它的值小于min
                {
                    min = weight[j];
                    indexMin = j ;
                }
            }
            resultNode[index++] = nodeName[indexMin];
            weight[indexMin] = 0;/* 表示该点已经访问了 */
//            接下来需要调整 maps的权值
            /* 一轮循环下来可以找到最小的那条边 */
            //调整权值
            for (int k = 0; k < num; k++)
            {
                if(weight[k] != 0 && maps[indexMin][k] < weight[k])
                {
                    weight[k] = maps[indexMin][k];
                }
            }


        }
        /* 打印路径 */
        for (int k = 0; k < index ; k++)
        {
            System.out.print(resultNode[k]+" ");
        }
    }
    
    public static void main(String[] args)
    {
        
        int[][] maps = {
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {0, 12, INF, INF, INF, 16, 14},
                /*B*/ {12, 0, 10, INF, INF, 7, INF},
                /*C*/ {INF, 10, 0, 3, 5, 6, INF},
                /*D*/ {INF, INF, 3, 0, 4, INF, INF},
                /*E*/ {INF, INF, 5, 4, 0, 2, 8},
                /*F*/ {16, 7, 6, INF, 2, 0, 9},
                /*G*/ {14, INF, INF, INF, 8, 9, 0}};
        prim(maps,0);
    }

}
