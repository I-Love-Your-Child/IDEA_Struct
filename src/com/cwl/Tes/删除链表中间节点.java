package com.cwl.Tes;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 16:44 2020-05-25
 */

/**
 *
 * @ClassName: 删除链表中间节点
 * @Description TODO
 * @Author:
 * @Date: 2020-05-25 16:44 
 * @Version" 1.0
 */
public class 删除链表中间节点
{
    public  static  Node removeMidNode(Node head)
    {
//        if(head == null || head.next == null)
//        {
//            return head;
//        }
//        if(head.next.next == null)
//        {
//            return head.next;
//        }
//        Node fast = head.next.next;//快指针
//        Node slow = head; //慢指针
//        while(fast.next!=null && fast.next.next != null)
//        {
//           slow = slow.next;
//           fast = fast.next.next;
//        }
//
//        // 进行删除
//        slow.next = slow.next.next;
//        return head;
       if(head == null || head.next==null) // 0 或 1
       {
        return  head;
       }
       if(head.next.next ==null) // 2
       {
           return head.next;
       }
       // >= 3

       //确保链表数量大于2，快指针跑的才有意义
        Node fast  = head.next.next;//快指针
        Node slow = head.next;//慢指针

        while (fast.next != null && fast.next.next != null) //出口一定要小心(这里包含奇数和偶数节点的情况）
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next=slow.next.next;
        return head;
    }

}
