package com.cwl.LeetCode刷题;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 14:58 2020-05-17
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _61_旋转数组
 * @Description TODO
 * @Author:
 * @Date: 2020-05-17 14:58
 * @Version" 1.0
 */

//给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
//
//        示例 1:
//
//        输入: 1->2->3->4->5->NULL, k = 2
//        输出: 4->5->1->2->3->NULL
//        解释:
//        向右旋转 1 步: 5->1->2->3->4->NULL
//        向右旋转 2 步: 4->5->1->2->3->NULL
//        示例 2:
//
//        输入: 0->1->2->NULL, k = 4
//        输出: 2->0->1->NULL
//        解释:
//        向右旋转 1 步: 2->0->1->NULL
//        向右旋转 2 步: 1->2->0->NULL
//        向右旋转 3 步: 0->1->2->NULL
//        向右旋转 4 步: 2->0->1->NULL
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/rotate-list
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _61_旋转数组
{
    static class ListNode
    {
        int val;
        ListNode next;

        ListNode(int x)
        {
            val = x;
        }
    }

    public static ListNode rotateRight(ListNode head, int k)
    {
        if(head == null)
        {
            return null;
        }
        int nums = 0;
        for (ListNode p = head; p != null; p = p.next)
        {
            nums++;
        }
        int []res1 = new int[nums];
        int index= 0;
        for (ListNode p = head; p != null; p = p.next)
        {
            res1[index++] = p.val;
        }
        int []res2 = new int[nums];
        int tmp = k%nums;
        for (int i = 0; i < nums; i++)
        {
            res2[(i+tmp)%nums] = res1[i];
        }
        ListNode root = new ListNode(res2[0]);
        ListNode tail = root;
        for (int i = 1; i < nums; i++)
        {
            ListNode p = new ListNode(res2[i]);
            tail.next = p;
            tail = p;
        }
        return root;

    }

    public static void main(String[] args)
    {
        ListNode root = new ListNode(1);
        ListNode tail = root;
        ListNode p = new ListNode(2);
        tail.next = p;
        tail = p;
        ListNode p1 = new ListNode(3);
        tail.next = p1;
        tail = p1;
        ListNode p2 = new ListNode(4);
        tail.next = p2;
        tail = p2;
        ListNode p3 = new ListNode(5);
        tail.next = p3;
        tail = p3;
        rotateRight(root,2);
    }
}
