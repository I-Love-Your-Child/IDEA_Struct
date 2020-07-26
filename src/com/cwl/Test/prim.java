package com.cwl.Test;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 22:03 2020-05-10
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @ClassName: prim
 * @Description TODO
 * @Author:
 * @Date: 2020-05-10 22:03 
 * @Version" 1.0
 */
public class prim
{
    static void  prim(int[][]cost)
    {
        int num = cost[0].length;
        int []lowcost = new int[num];
        int []cloest = new int[num];
        boolean [] visited = new boolean[num];
        for (int i = 0; i < num; i++)
        {
            lowcost[i] = cost[0][i];
            cloest[i] = 0;
            visited[i] = false;
        }
        visited[0] = true;


        int sum = 0;

        for (int i = 0; i < num; i++)
        {
            int min = Integer.MAX_VALUE;
            int m=0;
            for (int j = 1; j < num; j++)
            {
                if(lowcost[j] < min && visited[j]==false)
                {
                    min=lowcost[j];
                    m = j;
                }
            }

            System.out.println(m + "-" + cloest[m]);
            sum += cost[m][cloest[m]];
            visited[m]= true;

            for (int j = 1; j < num; j++)
            {
                if(cost[m][j] < lowcost[j] && !visited[j])
                {
                    lowcost[j] = cost[m][j];
                    cloest[j]=m;
                }
            }
        }
        System.out.println(sum);
    }
    static final int INF = Integer.MAX_VALUE;
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] cost = new int[n ][n ];

        /**
         *  一开始直接把maps地图全部存入Integer.MAX_VALUE
         */
        for (int i = 0; i < n ; i++)
        {
            Arrays.fill(cost[i], INF);
        }


        for (int i = 0; i < m; i++)
        {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int p = scanner.nextInt();
            cost[x][y] = cost[y][x] = p;
        }
        Arrays.stream(cost).flatMapToInt(Arrays::stream).forEach(System.out::println);
        prim(cost);
    }
    /*
    6 10
    0 1 6
    0 2 1
    0 3 5
    1 2 5
    1 4 3
    2 3 5
    2 4 6
    2 5 4
    3 5 2
    4 5 6
     */
}
