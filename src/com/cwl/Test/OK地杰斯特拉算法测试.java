package com.cwl.Test;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 02:53 2020-05-11
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName: OK地杰斯特拉算法测试
 * @Description TODO
 * @Author:
 * @Date: 2020-05-11 02:53
 * @Version" 1.0
 */
public class OK地杰斯特拉算法测试
{
    public static char[] nodes = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
    public static final int INF = Integer.MAX_VALUE;

    /**
     * 外层一个for循环 0 - n-1
     * 内层两个for循环，
     * 内层第一个for循环是负责查找最短路径的点和边
     * 内层第二个for循环是根据第一个for循环查找出来的点去调整dist数组和prev数组
     */
    public static void 地杰斯特拉(int[][] maps, int start)
    {
        int num = maps.length;
        int[] prev = new int[maps.length];
        int[] dist = new int[maps.length];
        boolean[] visited = new boolean[maps.length];
        for (int i = 0; i < num; i++)
        {
            visited[i] = false;
            prev[i] = start;
            dist[i] = maps[start][i];
        }
        visited[start] = true;
        dist[start] = 0;

        for (int i = 1; i < num; i++)
        {
            int min = INF;
            int k = 0;
            for (int j = 0; j < num; j++)
            {
                if (!visited[j] && dist[j] < min)
                {
                    min = dist[j];
                    k = j;
                }
            }
            visited[k] = true;

            /* 根据新增的节点调整最短路径数组 */
            for (int j = 0; j < num; j++)
            {
                int tmp = maps[k][j] == INF ? INF : min + maps[k][j];
                if (!visited[j] && dist[j] > tmp)
                {
                    dist[j] = tmp; /* 对于不可达的节点仍然是INF */
                    prev[j] = k; /* j 节点的前一个节点是k节点了 */
                }
            }
        }
        /* 打印最短路径的值 */
        for (int i = 0; i < num; i++)
        {
            System.out.println(nodes[start] + "-" + nodes[i] + "的最短路径为： " + dist[i]);
            System.out.print("最短路径为：");
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(i);
            int tmp = i;
            while (tmp != start)
            {
                tmp = prev[tmp];
                stack.push(tmp);
            }
            while (!stack.isEmpty())
            {
                if (stack.size() == 1)
                {
                    System.out.print(nodes[stack.poll()]);
                } else
                {
                    System.out.print(nodes[stack.poll()]+"->");
                }
            }
            
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        int matrix[][] = {
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {0, 12, INF, INF, INF, 16, 14},
                /*B*/ {12, 0, 10, INF, INF, 7, INF},
                /*C*/ {INF, 10, 0, 3, 5, 6, INF},
                /*D*/ {INF, INF, 3, 0, 4, INF, INF},
                /*E*/ {INF, INF, 5, 4, 0, 2, 8},
                /*F*/ {16, 7, 6, INF, 2, 0, 9},
                /*G*/ {14, INF, INF, INF, 8, 9, 0}};
        地杰斯特拉(matrix, 3);
    }
}
