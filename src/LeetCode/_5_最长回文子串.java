package LeetCode;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 10:12 2020-05-25
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName: _5_最长回文子串
 * @Description TODO
 * @Author:
 * @Date: 2020-05-25 10:12
 * @Version" 1.0
 */
public class _5_最长回文子串
{
    public static String longestPalindrome(String s)
    {
//        
//        ArrayDeque<Character> stack = new ArrayDeque<>();
//        ArrayDeque<Character> queue = new ArrayDeque<>();
//        for (int i = 0; i < s.length(); i++)
//        {
//            
//        }
        if(s.length()==1 )
        {
            return s;
        }
        StringBuilder sb  = new StringBuilder();
        
        for (int i =  s.length()-1;i >=0 ;i--)
        {
            sb.append(s.charAt(i));    
        }
        String rs = sb.toString();
        int index  = 0;
        int len = 0;
        int tmpIndex = 0;
        int tmpLen = 0;
        for (int i = 0; i < s.length(); )
        {
            tmpLen = 0;
            if(s.charAt(i) == rs.charAt(i))
            {
                tmpIndex = i;
                tmpLen++;
                i++;
                for (int j = i+1; j < s.length(); j++)
                {
                    if(s.charAt(j) == rs.charAt(j))
                    {
                        tmpLen++;
                        i++;
                    }else {
                        break;
                    }
                }
                if(tmpLen>len)
                {
                    len = tmpLen;
                    index = tmpIndex;
                }
            }else
            {
                i++;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = index; i < index + len; i++)
        {
            res.append(s.charAt(i));
        }
        if(res.length()==0)
        {
            return s.charAt(0)+"";
        }
        return res.toString();
    }

    public static void main(String[] args)
    {
        System.out.println(longestPalindrome("bb"));
    }
}
