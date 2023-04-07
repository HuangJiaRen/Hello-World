package com.xdf.huangli.leetCode;

/**
 * <p>
 *
 * </P>
 *
 * @author huangli
 * @since 4/6/23 9:07 AM
 */
public class CanJump {
    public boolean canJump(int[] nums){
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; i++) {
            if(i <= rightmost){
                rightmost = Math.max(rightmost, i + nums[i]);
                if(rightmost >= n - 1){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CanJump canJump = new CanJump();
        int[] ars = {2, 3, 1, 1, 4};
        boolean b = canJump.canJump(ars);
        System.out.println(b);
    }
}
