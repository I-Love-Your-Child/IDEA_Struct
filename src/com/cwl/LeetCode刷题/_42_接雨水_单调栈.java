package com.cwl.LeetCode刷题;
/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 22:33 2020-05-13
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @ClassName: _42_接雨水_单调栈
 * @Description TODO
 * @Author:
 * @Date: 2020-05-13 22:33
 * @Version" 1.0
 */
public class _42_接雨水_单调栈
{
//    public static int trap(int[] height)
//    {
//        if (height == null)
//        {
//            return 0;
//        }
//        /* 因为stack是接口，所以调用的都是抽象方法，说明是接口的代理对象在起作用 */
//        Deque<Integer> stack = new ArrayDeque<>();
//        int result = 0;
//        for (int i = 0; i < height.length; i++)
//        {
//            while (!stack.isEmpty() && height[stack.peek()] < height[i])
//            {
//                int curIdx = stack.pop();
//                while (!stack.isEmpty() && height[stack.peek()] == height[curIdx])
//                {
//                    stack.pop();
//                }
//                if (!stack.isEmpty())
//                {
//                    int stackTop = stack.peek();
//                    result += (Math.min(height[stackTop], height[i]) - height[curIdx]) * (i - stackTop - 1);
//                }
//            }
//            stack.add(i);
//        }
//        return result;
//    }


//    目前采用分治的思路，执行速度99.9%，根据木桶效应的想法，找到最高点，然后依次向左，向右遍历，求差
    public static int trap(int[] height)
    {
        // 木桶效应，找到最高的点，然后从最高点，向左右扩散
        if (height.length == 0)
        {
            return 0;
        }

        int max = 0;
        int indexOfHighest = 0;
        for (int i = 0; i < height.length; i++)
        {
            if (height[i] > max)
            {
                max = height[i];
                indexOfHighest = i;
            }
        }

        // 求左侧面积
        int areaLeft = left(indexOfHighest, height);
        // 求右侧面积
        int areaRight = right(indexOfHighest, height);

        return areaLeft + areaRight;
    }

    private static int left(int mid, int[] height)
    {
        if (mid == 0)
        {
            return 0;
        }
        // 依次找左侧最高点
        int index = mid - 1;
        int highest = 0;
        int indexOfhighest = 0;
        for (; index >= 0; index--)
        {
            if (height[index] >= highest)
            {
                highest = height[index];
                indexOfhighest = index;
            }
        }

        // 求总面积
        int area = highest * (mid - (indexOfhighest + 1));

        int pillars = 0;
        int i = indexOfhighest + 1;
        for (; i < mid; i++)
        {
            pillars += height[i] * 1;
        }
        int water = (area - pillars) + left(indexOfhighest, height);
        return water;
    }

    private static int right(int mid, int[] height)
    {
        if (mid == height.length - 1)
        {
            return 0;
        }
        // 依次找到右侧最高点
        int index = mid + 1;
        int max = 0;
        int idx = 0;
        for (; index < height.length; index++)
        {
            if (height[index] >= max)
            {
                max = height[index];
                idx = index;
            }
        }
        // 求第一高 与 第二高之间的水面积
        int area = max * (idx - (mid + 1));
        int pillars = 0;
        int i = mid + 1;
        for (; i < idx; i++)
        {
            pillars += height[i] * 1;
        }

        int water = (area - pillars) + right(idx, height);
        return water;
    }

    public static void main(String[] args)
    {
        int[] test = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(test));
    }
}
