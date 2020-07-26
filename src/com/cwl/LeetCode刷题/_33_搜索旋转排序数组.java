package com.cwl.LeetCode刷题;
/**
 * @Author: 陈文龙
 * @Description;
 * @Date: created in 16:30 2020-05-11
 */

/**
 * @ClassName: _33_搜索旋转排序数组
 * @Description
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author:
 * @Date: 2020-05-11 16:30
 * @Version" 1.0
 */
public class _33_搜索旋转排序数组
{
    /*
    思路：如果中间的数小于最右边的数，则右半段是有序的，若中间数大于最右边数，则左半段是有序的，我们只要在有序的半段里用首尾两个数组来判断目标值是否在这一区域内，这样就可以确定保留哪半边了
     */
    public static int search(int[] nums, int target)
    {
        int len = nums.length;
        int left = 0, right = len - 1;
        while (left <= right)
        {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < nums[right])
            {
                if (nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            } else
            {
                if (nums[left] <= target && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int[] nums = {4,5,6,7,0,1,2};
        int target;
        System.out.println(search(nums,0));
        System.out.println(search(nums,3));

    }
    /**
     * 输出：
     * 4
     * -1
     *
     */
}
