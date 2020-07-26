package com.cwl.Tes;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 17:08 2020-05-25
 */

import java.util.ArrayDeque;

/**
 *
 * @ClassName: 判断回文链表
 * @Description TODO
 * @Author:
 * @Date: 2020-05-25 17:08 
 * @Version" 1.0
 */
public class 判断回文链表
{
    public static boolean f1(Node head)
    {
//        ArrayDeque<Node> stack = new ArrayDeque<>();
//        if(head==null || head.next == null)
//        {
//            return  false;
//        }
//        Node tmp = head;
//        while(tmp!=null)
//        {
//            stack.push(tmp);
//            tmp = tmp.next;
//        }
//        while (!stack.isEmpty())
//        {
//            Node t = stack.pop();
//            if(t.value != head.value)
//            {
//                return false;
//            }
//            head = head.next;
//        }
//        return true;
//        ArrayDeque<Node> stack = new ArrayDeque<>();
//        if(head == null || head.next == null)
//        {
//            return false;
//        }
//        Node fast = head; // 快指针
//        Node slow = head; // 慢指针
//        while(fast.next != null && fast.next.next != null) // 奇数 + 偶数情况下
//        {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        System.out.println(slow.value);
//        slow = slow.next;
//        while (slow != null)
//        {
//            stack.push(slow);
//            slow = slow.next;
//        }
//        while (!stack.isEmpty())
//        {
//            Node tmp = stack.pop();
//            if(head.value != tmp.value)
//            {
//                return false;
//            }
//            head = head.next;
//        }
//        return true;

     if(head == null || head.next == null)
     {
         return  true;
     }
     Node fast = head;
     Node slow = head;
     while (fast.next !=null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node revHead = reverse(slow.next);

     //进行比较
        while (revHead != null)
        {
            System.out.println(revHead.value);
            if(revHead.value != head.value)
            {
                return false;
            }
            head = head.next;
            revHead = revHead.next;
        }
        return  true;
    }

    // 反转链表
    private static Node reverse(Node head)
    {
        if(head==null||head.next ==null)
        {
            return head;
        }
        Node newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return  newHead;
    }


    public static void main(String[] args)
    {

    }
}
