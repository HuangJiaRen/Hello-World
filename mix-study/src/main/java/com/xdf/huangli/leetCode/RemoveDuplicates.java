package com.xdf.huangli.leetCode;

/**
 * @author huangli
 * @version 1.0
 * @description
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 *
 * 给定数组 nums = [1,1,2],
 *
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * @date 2020-08-09 22:26
 *
 * 方法：双指针法
 * 算法
 *
 * 数组完成排序后，我们可以放置两个指针 i 和 j，其中 i 是慢指针，
 * 而 j 是快指针。只要 nums[i] = nums[j]，我们就增加 j 以跳过重复项。
 *
 * 当我们遇到 nums[j] != nums[i]，
 * 跳过重复项的运行已经结束，因此我们必须把它（nums[j]）的值复制到
 * nums[i + 1]。然后递增 i，接着我们将再次重复相同的过程，直到 j 到达数组的末尾为止。
 *
 */
public class RemoveDuplicates {
    public static void main(String[] args) {

        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        int i = removeDuplicates(nums);

        System.out.println(i);
    }

    public static int removeDuplicates(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }

            int i = 0;

            for (int j = 1; j < nums.length; j++) {
                if(nums[j] != nums[i]){
                    i ++;
                    nums[i] = nums[j];
                }
            }


           return i+1;
    }

}
