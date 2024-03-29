package com.xdf.huangli.leetCode;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * @author huangli
 * @version 1.0
 * @description
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * @date 2020-09-10 16:56
 */
public class SearchInsertTest {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 7;
        int insert = searchInsert(nums, target);
        System.out.println(insert);

    }

    public static int searchInsert(int[] nums, int target){
        int res = 0;
        boolean rf = false;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target){
                res = i;
                rf = true;
                break;
            }
        }

        if(!rf){
            if(nums.length == 1){
                if(nums[0] < target){
                    res = 1;
                }else {
                    res = 0;
                }
            }else {
                for (int i = 0; i < nums.length; i++) {
                    if((nums[i] < target && (i + 1) < nums.length && target < nums[i + 1]) || nums[nums.length - 1] < target){
                        res = i + 1;
                    }
                }
            }

        }

        return res;
    }
}
