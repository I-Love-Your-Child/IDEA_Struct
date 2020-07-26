package LeetCode;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 09:28 2020-05-25
 */

import java.util.HashSet;

/**
 * @ClassName: _3_无重复的最长子串
 * @Description TODO
 * @Author:
 * @Date: 2020-05-25 09:28
 * @Version" 1.0
 */
public class _3_无重复的最长子串
{
    public static int lengthOfLongestSubstring(String s)
    {
        if (s == null || s.equals(""))
        {
            return 0;
        }
        if (s.length() == 1)
            return 1;
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        for (int i = 0; i < s.length() - 1; i++)
        {
            set.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++)
            {
                if (set.contains(s.charAt(j)))
                {
                    break;
                } else
                    set.add(s.charAt(j));


            }
            if (set.size() > max)
            {
                max = set.size();
            }
            set.clear();

        }
        return max;
    }

    public static void main(String[] args)
    {
        String s = " ";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
