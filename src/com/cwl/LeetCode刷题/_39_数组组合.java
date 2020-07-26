package com.cwl.LeetCode刷题;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 20:01 2020-05-13
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: _39_数组组合
 * @Description TODO
 * @Author:
 * @Date: 2020-05-13 20:01
 * @Version" 1.0
 */
public class _39_数组组合
{
    /*
     *
      *给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

    candidates 中的数字可以无限制重复被选取。

    说明：

    所有数字（包括 target）都是正整数。
    解集不能包含重复的组合。 
    示例 1:

    输入: candidates = [2,3,6,7], target = 7,
    所求解集为:
    [
      [7],
      [2,2,3]
    ]
    示例 2:

    输入: candidates = [2,3,5], target = 8,
    所求解集为:
    [
      [2,2,2,2],
      [2,3,3],
      [3,5]
    ]

     */

    /**
     * 递归和回溯打印的过程
     */

    /*
    ### 回朔法的思想： 回朔法的重要思想在于： 通过枚举法，对所有可能性进行遍历。 但是枚举的顺序是 一条路走到黑，发现黑之后，退一步，再向前尝试没走过的路。直到所有路都试过。因此回朔法可以简单的理解为： 走不通就退一步的方枚举法就叫回朔法。而这里回退点也叫做回朔点。

### 回朔关键点 通过分析发现，回朔法实现的三大技术关键点分别是：

一条路走到黑
回退一步
另寻他路
### 关键点的实现 那么如何才能用代码实现上述三个关键点呢？

for 循环
递归
#### 解释如下

for循环的作用在于另寻他路： 你可以用for循环可以实现一个路径选择器的功能，该路径选择器可以逐个选择当前节点下的所有可能往下走下去的分支路径。 例如： 现在你走到了节点a，a就像个十字路口，你从上面来到达了a，可以继续向下走。若此时向下走的路有i条，那么你肯定要逐个的把这i条都试一遍才行。而for的作用就是可以让你逐个把所有向下的i个路径既不重复，也不缺失的都试一遍

递归可以实现一条路走到黑和回退一步： 一条路走到黑： 递归意味着继续向着for给出的路径向下走一步。 如果我们把递归放在for循环内部，那么for每一次的循环，都在给出一个路径之后，进入递归，也就继续向下走了。直到递归出口（走无可走）为止。 那么这就是一条路走到黑的实现方法。 递归从递归出口出来之后，就会实现回退一步。

 因此for循环和递归配合可以实现回朔： 当递归从递归出口出来之后。上一层的for循环就会继续执行了。而for循环的继续执行就会给出当前节点下的下一条可行路径。而后递归调用，就顺着这条从未走过的路径又向下走一步。这就是回朔

说了这么多，回朔法的通常模板是什么呢？ 递归和for又是如何配合的呢？
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        List<List<Integer>> listAll = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        // 排序
        Arrays.sort(candidates);
        find(listAll,list,candidates,target,0);
        return listAll;

    }

    public static void find(List<List<Integer>> listAll,List<Integer> tmp,int[] candidates,int target,int indexStart)
    {
        //递归的终点
        if(target == 0)
        {
            listAll.add(tmp);
            return;
        }
        if(target<candidates[0])
        {
            return;
        }

        // for循环 + 递归 ！！
        // for循环中的条件判断实际上是剪枝处理
        for (int i = indexStart; i < candidates.length && candidates[i] <= target ; i++)
        {
            // 拷贝一份，不影响下一次递归
            List<Integer> list = new ArrayList<>(tmp);
            list.add(candidates[i]);
            // 递归运算 ， 将i传递至下一次运算是为了避免结果重复
            find(listAll,list,candidates,target - candidates[i],i);
        }
    }

    public static void main(String[] args)
    {
        int[] test = {2,3,5};
        int target = 8;
        List<List<Integer>> res = combinationSum(test,target);
        res.forEach((a) ->
        {

            a.forEach((a1)-> System.out.print(a1 + " "));
            System.out.println();
        });

        /*
        输出：
        2 2 2 2
        2 3 3
        3 5
         */

    }
}
