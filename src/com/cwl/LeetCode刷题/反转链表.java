package com.cwl.LeetCode刷题;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 14:03 2020-05-24
 */

/**
 * @ClassName: 反转链表
 * @Description TODO
 * @Author:
 * @Date: 2020-05-24 14:03
 * @Version" 1.0
 */
public class 反转链表
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

    static Node reverseList(Node head)
    {
        Node next = null;
        Node pre = null;
        while(head!=null)
        {
           next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return  pre;
    }

    static void print(Node head)
    {
        while(head!=null)
        {
            System.out.println(head.value);
            head=head.next;
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
        print(head);
        Node newHead =   reverseList(head);
        System.out.println("---------------- 我是分隔符 ----------------");
        print(newHead);

    }
}
