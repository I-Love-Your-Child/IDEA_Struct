package com.cwl.Tes;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 16:19 2020-05-25
 */

import org.w3c.dom.Node;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: ttt
 * @Description TODO
 * @Author:
 * @Date: 2020-05-25 16:19
 * @Version" 1.0
 */
public class ttt
{
    class Node2
    {

        public int value;
        public Node2 left;
        public Node2 right;

        public Node2(int value)
        {
            this.value = value;
        }

    }

    public static Node2 convert1(Node2 head)
    {

//        Queue<Node2> queue = new LinkedList<>(); //将节点按中序遍历放进队列⾥
//        inOrderToQueue(head, queue);
//        head = queue.poll();
//        Node2 pre = head;
//        pre.left = null;
//        Node2 cur = null;
//        while (!queue.isEmpty())
//        {
//
//            cur = queue.poll();
//
//            pre.right = cur;
//
//            cur.left = pre;
//
//            pre = cur;
//        }
//
//        pre.right = null;
//        return head;
        /*
        ArrayDeque<Node2> queue = new ArrayDeque<>();
        inOrderToQueue(head,queue);
        head = queue.poll();
        Node2 pre = head;  // 因为最后要return head，所以需要保持head不懂
        pre.left = head;
        Node2 cur = null;
        while (!queue.isEmpty())
        {
            cur = queue.poll();
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        pre.right = null;
        return head;
        */

        ArrayDeque<Node2> queue = new ArrayDeque<>();
        inOrderToQueue(head,queue);

        // 开始构建双向链表
        // 返回 head，故head不能动
        Node2 pre = head;
        Node2 cur = null;
        while(!queue.isEmpty())
        {
           cur = queue.poll();

           pre.right = cur;
           cur.left = pre;
           pre = cur;
        }
        pre.right = null;
        return head;

    }

    private static void inOrderToQueue(Node2 head, Deque<Node2>queue)
    {
        /**
        if (head == null)
        {
            return;
        }
        inOrderToQueue(head.left, queue);
        queue.offer(head);
        inOrderToQueue(head.right, queue);
         */

        if(head == null)
        {
            return;
        }
        inOrderToQueue(head,queue);
        queue.offer(head);
        inOrderToQueue(head,queue);

    }
}
