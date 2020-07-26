package com.cwl.Tes;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 17:07 2020-05-25
 */

/**
 * @ClassName: aaaa
 * @Description TODO
 * @Author:
 * @Date: 2020-05-25 17:07
 * @Version" 1.0
 */
public class aaaa
{
    public static Node josephusKill(Node head, int m)
    {
        if (head == null || m < 1) return head;
        Node last = head; //定位到最后⼀个节点
        while (head.next != last)
        {
            head = head.next;
        }
        System.out.println(head.value);
        int count = 0;
        while (head.next != head)
        {
            if (++count == m)
            {
                head.next = head.next.next;
                count = 0;
            } else
            {
                head = head.next;
            }

        }
        return head;

    }
}
