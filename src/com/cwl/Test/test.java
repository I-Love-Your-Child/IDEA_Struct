package com.cwl.Test;
/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 21:36 2020-05-10
 */

/**
 *
 * @ClassName: 选择最大的K个数
 * @Description TODO
 * @Author:
 * @Date: 2020-05-10 21:36 
 * @Version" 1.0
 */
public class test
{
    static void prim(int[][] maps,int 起点)
    {
        int[] lowcost = new int[maps[0].length];
        int[] cloest = new int[maps[0].length];
        for (int i = 0; i < maps[0].length; i++)
        {
            lowcost[i] = maps[起点][i];
        }
        cloest[起点] = 0;
    }
}
