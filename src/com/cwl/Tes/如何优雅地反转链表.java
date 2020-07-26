package com.cwl.Tes;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 16:55 2020-05-25
 */

/**
 * @ClassName: 如何优雅地反转链表
 * @Description TODO
 * @Author:
 * @Date: 2020-05-25 16:55
 * @Version" 1.0
 */
public class 如何优雅地反转链表
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

    public static Node reverseList(Node head)
    {
//        /* 相当于多了一个傀儡前驱节点null节点 */
//        Node next = null; //指向当前节点的后驱
//        Node pre = null; // 指向当前节点的前驱（傀儡节点）
//        while (head!=null)
//        {
//            next = head.next;
//            // 当前节点的后驱指向前驱
//            head.next = pre;
//            pre  = head;
//            // 处理下一个节点
//            head = next;
//        }
//        return  pre;
        Node pre = null;
        Node next = null;
        while (head!=null)
        {
            next = head.next;
            head.next = pre;
            pre = head; // pre指向next节点的前驱节点
            head = next;
        }
        return  pre;
    }


}
