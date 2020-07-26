package com.cwl.Tes;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 16:36 2020-05-25
 */

/**
 * @ClassName: ad
 * @Description TODO
 * @Author:
 * @Date: 2020-05-25 16:36
 * @Version" 1.0
 */
class Node
{

    public int value;
    public Node next;

    public Node(int data)
    {
        this.value = data;
    }

}

public class 删除倒数第K个节点
{

    /* 注意是删除倒数的节点 */
    public Node removeLastKthNode(Node head, int K)
    {
        if(head == null || K <1)
        {
            return head;
        }
        Node tmp = head;
        int num = 0;
        while(tmp != null)
        {
           num++;
           tmp=tmp.next;
        }
        if(num == K)
        {
            return head.next;
        }
        if(num>K)
        {
            tmp = head;
            //删除第num-k+1个节点
            //定位到这个节点的前驱
            while(num - K != 0)
            {
               tmp = tmp.next;
               num--;
            }
            tmp.next = tmp.next.next;
        }
        return head;
    }

}


