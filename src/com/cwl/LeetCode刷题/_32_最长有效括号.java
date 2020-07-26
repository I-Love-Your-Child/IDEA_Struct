package com.cwl.LeetCode刷题;
/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 15:52 2020-05-11
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName: _32_最长有效括号
 * @Description 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 * <p>
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author:
 * @Date: 2020-05-11 15:52
 * @Version" 1.0
 */


public class _32_最长有效括号
{
    /**
     * 对字符串遍历，进行括弧有效性验证，记录最大的有效长度。同样的方式，倒序再来一次，取最大值。时间复杂度 2*s.leng
     *
     */
    public static int longestValidParentheses(String s)
    {
        char[] chars = s.toCharArray();
        return Math.max(calc(chars, 0, 1, chars.length, '('),       calc(chars, chars.length - 1, -1, -1, ')'));
    }

    private static int calc(char[] chars, int i, int flag, int end, char cTem)
    {
        int max = 0, sum = 0, currLen = 0, validLen = 0;
        for (; i != end; i += flag)
        {
            sum += (chars[i] == cTem ? 1 : -1);
            currLen++;
            if (sum < 0)
            {
                max = max > validLen ? max : validLen;
                sum = 0;
                currLen = 0;
                validLen = 0;
            } else if (sum == 0)
            {
                validLen = currLen;
            }
        }
        return max > validLen ? max : validLen;
    }

    public static void main(String[] args)
    {
        String test1 = "(()";
        String test2 = ")()())";
        System.out.println(longestValidParentheses(test1));
        System.out.println(longestValidParentheses(test2));
    }

    /**  更容易理解的思路！
     *
     * 用栈模拟一遍，将所有无法匹配的括号的位置全部置1
     * 例如: "()(()"的mark为[0, 0, 1, 0, 0]
     * 再例如: ")()((())"的mark为[1, 0, 0, 1, 0, 0, 0, 0]
     * 经过这样的处理后, 此题就变成了寻找最长的连续的0的长度
     */
}
