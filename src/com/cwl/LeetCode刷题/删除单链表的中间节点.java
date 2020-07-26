package com.cwl.LeetCode刷题;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 14:10 2020-05-24
 */

/**
 * @ClassName: 删除单链表的中间节点
 * @Description TODO
 * @Author:
 * @Date: 2020-05-24 14:10
 * @Version" 1.0
 */
public class 删除单链表的中间节点
{
    static class Node
    {

        public int value;
        public Node next;

        public Node(int data)
        {
            this.value = data;
        }

    }

    /* 快慢指针法 */
    static Node removeMidNode(Node head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }
        if (head.next.next == null)
        {
            return head.next;
        }

        Node fast = head.next.next;
        Node slow = head;

        while (fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        //进行删除
        slow.next = slow.next.next;
        return head;
    }

    static void print(Node head)
    {
        while (head != null)
        {
            System.out.println(head.value);
            head = head.next;
        }
    }

    public static void main(String[] args)
    {
        Node head = new Node(-1);
        Node tail = head;
        for (int i = 0; i < 10; i++)
        {
            Node p = new Node(i);
            tail.next = p;
            tail = tail.next;
        }
        print(removeMidNode(head));
        System.out.println("---------------- 我是分隔符 ----------------");
        Node head1 = new Node(-100);
        print(removeMidNode(head1));
    }
}
