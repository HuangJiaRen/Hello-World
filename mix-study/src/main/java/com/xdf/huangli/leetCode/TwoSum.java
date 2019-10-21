package com.xdf.huangli.leetCode;

import com.google.common.collect.Maps;

import java.lang.reflect.Array;
import java.util.HashMap;

/**
 * @author huangli
 * @version 1.0
 * @description
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * @date 2019-10-20 23:02
 */
public class TwoSum {
    public static void main(String[] args) {
//       int[] nums = {11, 3, 5, 2, 7, 15};
       int[] nums = {6,5,7,8,9,3};
//       int target = 9;
       int target = 10;
       int[] res = twoSum_2(nums, target);
        System.out.println(res[0] + "---" + res[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int a = 0;
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                a = nums[i] + nums[j];
                if (a == target){
                    res[0] = i;
                    res[1] = j;
                    break;
                }
            }

            if(a == target){
                break;
            }
        }

        return res;
    }


    public static int[] twoSum_2(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = Maps.newHashMap();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int aa = target - nums[i];
            if(hashMap.containsKey(aa)){
                res[0] = hashMap.get(aa);
                res[1] = i;
            }

            hashMap.put(nums[i],i);
        }

        return res;
    }
}
