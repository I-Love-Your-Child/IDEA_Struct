package 搞定链表;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 1:40 上午 2020/7/25
 */

/**
 * @ClassName: 删除单链表第K个节点
 * @Description TODO
 * @Author:
 * @Date: 2020/7/25 1:40 上午
 * @Version" 1.0
 */
class Node1
{
    public int value;
    public Node1 next;
    public Node1(int data)
    {
        this.value = data;
    }
}

public class 删除单链表倒数第K个节点
{
    public Node1 removeKNode(Node1 root, int K)
    {
        if(root==null || K<1)
        {
            return root;
        }
        Node1 tmp = root;
        int num = 0;
        while (tmp != null)
        {
            tmp = root;
            //删除第num - K + 1 个节点
            //定位到节点的前驱
            while(num - K != 0)
            {
               tmp = tmp.next;
               num++;
            }

            if(num==K)
            {
                return root.next;
            }
            if(num > K)
            {
                tmp = root;
                while (num - K != 0 )
                {
                    tmp = tmp.next;
                    num--;
                }
                tmp.next = tmp.next.next;
            }
            return root;
        }
        return null;
    }
}
