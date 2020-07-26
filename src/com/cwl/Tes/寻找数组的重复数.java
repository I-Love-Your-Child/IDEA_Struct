package com.cwl.Tes;/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 22:10 2020-05-26
 */

/**
 * @ClassName: 寻找数组的重复数
 * @Description TODO
 * @Author:
 * @Date: 2020-05-26 22:10
 * @Version" 1.0
 */
public class 寻找数组的重复数
{
    public int findDuplicate(int[] nums)
    {
        // 将其看成是一个循环的链表，快慢指针循环
        int slow = 0;
        int fast = 0;
        do
        {
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];

        } while (nums[slow] != nums[fast]);
        slow = 0;
// 找出在哪个位置为起始点，可证必定在圆圈起点相遇
        while (slow != fast)
        {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
