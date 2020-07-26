package com.cwl.Test;/**
 * @Author: 陈文龙
 * @Description: https://wenku.baidu.com/view/5a08390ada38376bae1fae2a.html
 * @Date: created in 16:27 2020-05-09
 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

/**
 * @ClassName: OKPrim正式算法
 * @Description 算法的核心数据结构就是两个数组：  lowcost数组 和 closet数组
 * 对 j∈VS, closet [j] 表示点j与所有 S 中点的连线中最短的连接点
 * 而 lowcost[j] 的值就是 c[j][closet[j]]
 * <p>
 * 在算法的执行过程中，先找出 V-S 中是 lowcost！值最小的点，选取边（j, closet [j]）将j添加到 S 中，然后根据与新加入 S 的点的距离的比较，更新 lowcost的 数组。
 * @Author:
 * @Date: 2020-05-09 16:27
 * @Version" 1.0
 */

/**
 * 核心思想：
 * lowcost[j] 永远保留着已选的节点集合到 j点之间最短的距离。 因为一开始只有一个点节点，所以初始值是根节点到j的距离。然后随着逐渐加入新的节点，根据新加入的节点来调整lowcost的值。每次只需要考虑新加入的点来更新lowcost即可，因为这是一种数学归纳法可以证明。
 *
 *
 */

/**
 *  DJ  ===== Prim
 * 两者的区别在于，每次更新路径的不一样
 *
 * prim更新的是未标记集合到已标记集合之间的距离
 *
 * Dijkstra更新的是源点到未标记集合之间的距离
 */

/**
 *
 * Prim 和 DJ的代码几乎一模一样，除了DJ中的prev数组和 Prim中的cloest数组的区别。
 */
public class OKPrim正式算法
{

    static final int INF = Integer.MAX_VALUE;

    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] cost = new int[n][n];

        /**
         *  一开始直接把maps地图全部存入Integer.MAX_VALUE
         */
        for (int i = 0; i < n; i++)
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

        prim(cost, n, 1);
    }

    /**
     * prim算法也是外层一个 0 - n-1的for循环
     * 内层两个for循环
     * 内层第一个for循环用来寻找最短的边和点
     * 内层第二个for循环是利用第一个for'循环找到的边和点去更新lowcost和cloest数组
     */
    public static void prim(int[][] cost, int n, int start)
    {
        int lowcost[] = new int[n]; // 相当于DJ中的dist数组
        int closest[] = new int[n];
        boolean[] visited = new boolean[n]; // 相当于DJ中的visited数组
        for (int i = 0; i < n; i++)
        {
            // 由于此时S={1},所以S中只包含点1，所以此时：cloest[i] = 1
            // lowcost[i]=cost[1][i]
            visited[i] = false;
            lowcost[i] = cost[start][i];// INF表示两点之间没有直接的连线
            closest[i] = start; //起点都是0
        }
        visited[start] = true;
        int min, m;
        //寻找邻近最小路径

        int sum = 0;
        for (int i = 1; i < n; i++) // n-1 次for循环
        {
            min = INF;
            m = 0;
            // 第一次循环，遍历lowcost数组，找到最小的值为lowcost[3]=1，并将该点加入到S中。此时 S={1,3}
            for (int j = 0; j < n; j++)
            {
                if (lowcost[j] < min && !visited[j])
                {
                    m = j;
                    min = lowcost[j];
                }
            }
            // cloest 数组的下标和元素的值凑成了一条边
            // 输出生成树的边
            System.out.println("closest[" + m + "]=" + closest[m]);
            sum += cost[m][closest[m]];
            lowcost[m] = 0;
            visited[m] = true;

            //根据新增的节点来更新lowcost数组，
            //调整代价
            for (int j = 0; j < n; j++)
            {
                if (!visited[j] && cost[m][j] < lowcost[j] )
                {
                    /* 同样 lowcost和closet数组的修改发生在第二个for循环中 */
                    lowcost[j] = cost[m][j];
                    closest[j] = m;
                }
            }
        }
        System.out.println("MST = " + sum);

        /* 打印最短路径的值 */
        for (int i = 0; i < cost.length; i++)
        {
            System.out.println(start + "-" + i + "的最短路径为： " + lowcost[i]);
            System.out.print("最短路径为：");
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(i);
            int tmp = i;
            while (tmp != start)
            {
                tmp = closest[tmp];
                stack.push(tmp);
            }
            while (!stack.isEmpty())
            {
                if (stack.size() == 1)
                {
                    System.out.print(stack.poll());
                } else
                {
                    System.out.print(stack.poll() + "->");
                }
            }
            System.out.println();
        }
    }
    /*
    输入：
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
    输出：
    closest[2]=0
    closest[5]=2
    closest[3]=5
    closest[1]=2
    closest[4]=1
    MST = 15
     */
    /**
     *
     * closest[3]=1
     * closest[6]=3
     * closest[4]=6
     * closest[2]=3
     * closest[5]=2
     * MST = 15
     */

}
