package 搞定链表;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 1:23 上午 2020/7/25
 */

import java.util.ArrayDeque;

/**
 *
 * @ClassName: 搜索二叉树转双向链表
 * @Description TODO
 * @Author:
 * @Date: 2020/7/25 1:23 上午
 * @Version" 1.0
 */


class Node
{
    public int value;
    public Node left;
    public Node right;
    public Node(int value)
    {
        this.value = value;
    }

}

// 时间复杂度为O(n），空间复杂度O(n)
public class 搜索二叉树转双向链表
{
    // 队列存中序遍历获得的节点
    public static Node getList(Node root)
    {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        inOrderTraceToQueue(root,queue);
        root = queue.poll(); // 弹出第一个节点
        // pre + cur 双指针遍历法

        //开头测试 两个 A，B 中途.... 最后结尾测一个即可。
        //一个扫描，一个哨兵。
        Node pre = root;
        pre.left = null;
        Node cur = null;
        while (!queue.isEmpty())
        {
            cur = queue.poll();
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        pre.right = null;
        return  root;
    }

    public static  void inOrderTraceToQueue(Node root, ArrayDeque<Node> queue)
    {
        if(root == null)
        {
            return;
        }
        inOrderTraceToQueue(root.left,queue);
        queue.offer(root);
        inOrderTraceToQueue(root.right,queue);
    }


    // 递归法

}
