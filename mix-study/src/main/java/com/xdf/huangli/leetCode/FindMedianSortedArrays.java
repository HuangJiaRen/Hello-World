package com.xdf.huangli.leetCode;


import java.util.Arrays;

/**
 * @author huangli
 * @version 1.0
 * @description 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * @date 2019-10-23 09:37
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5};
        int[] nums2 = {2, 4, 6};

        nums1 = Arrays.copyOf(nums1, nums1.length + nums2.length);
        System.arraycopy(nums2, 0, nums1, nums1.length - nums2.length, nums2.length);
        Arrays.sort(nums1);

        int len = nums1.length;
        int a = len % 2;
        double midNum = 0f;
        if(a == 0){
            int mid = len / 2;
             midNum = Double.valueOf((nums1[mid - 1] + nums1[mid])) / 2;
        } else {
            int mid = len / 2;
             midNum = Double.valueOf(nums1[mid]);
        }

        System.out.println( midNum);
    }
}
