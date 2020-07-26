package com.cwl.算法;
/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 15:59 2020-05-09
 */
/*
    插话一下：注意区别最小生成树和最短路径的区别：
    最小生成树：是指所有点都被染指 ====> 是所有点的问题
    最短路径：A ===> B 的最短路径，是两点之间的问题
 */
/*
    Prim算法是以点为研究对象，每次遍历点的临界边
    Kruskall算法是以边为研究对象，先sort一下边，然后每次取最小的边，然后进行取点操作
 */
/**
 *
 * @ClassName: Prim算法
 * @Description 最小生成树算法  ====> OKPrim正式算法
 * @Author: Prim算法
 * @Date: 2020-05-09 15:59 
 * @Version" 1.0
 */

public class Prim算法
{
    public static void main(String[] args)
    {
        int n = 6;
        // c[i][j]表示 从i ===> j的权值
        int [][]c = {
                {0,0,0,0,0,0},
                {0,-1,6,1,5,-1,-1},
                {0,6,-1,5,-1,3,-1},
                {0,1,5,-1,5,6,4},
                {0,5,-1,5,-1,-1,2},
                {0,-1,3,6,-1,-1,6},
                {0,-1,-1,4,2,6,-1}
        };
        prim(n,c);
    }

    public static void prim(int n,int [][]c)
    {
        // lowcost[i] 表示 从l ====> i 的最短权值
        int [] lowcost = new int[n+1];
        // clostest[i]的表示：
        /*
        将整个节点空间定为V，已选的空间从S=1（只有第一个点）开始，
		j在V-S中，找到S里离j最近的节点i ，就记录在closest[j]。
         */
        int[] cloest = new int[n+1];
        boolean [] s = new boolean[n+1];
        s[1]=true;
        // 上一行
        for (int i = 2; i <= n; i++)
        {
            lowcost[i] = c[1][i];
            cloest[i]=1;
            s[i]=false;
        }

        // n-1次遍历，把S空间扩充成V
        for (int i = 1; i <n ; i++)
        {
            int min = Integer.MAX_VALUE;
            int j=1;
            for (int k = 2; k <= n ; k++)
            {
                if(lowcost[k]!=-1 && lowcost[k] <min && !s[k])
                {
                    min = lowcost[k];
                    j = k;
                }
            }
            System.out.println(cloest[j] + "-" + j);
            s[j]=true;
            for (int k = 2; k < n; k++)
            {
                if(!s[k] && c[j][k] !=-1)
                {
                    if(c[j][k] < lowcost[k] || lowcost[k] == -1)
                    {
                        lowcost[k] = c[j][k];
                        lowcost[k]=j;
                    }
                }
            }
        }

    }
}
