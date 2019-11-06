package com.xdf.huangli.leetCode;

/**
 * @author huangli
 * @version 1.0
 * @description 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * @date 2019-11-06 09:55
 */
public class Solution {
    public static void main(String[] args) {
        int x = 1534566469;
        int revx = reverse(x);

        System.out.println(revx);
    }

    public static int reverse(int x){
        if(x == 0){
            return 0;
        }

        if(Integer.MAX_VALUE < x){
            return 0;
        }

        String xStr = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        if(xStr.charAt(xStr.length() - 1) == '0'){
            xStr = xStr.substring(0, xStr.length() - 1);
        }

        int len = xStr.length();
        for (int i = len - 1; i >= 0; i--) {
           sb.append(xStr.charAt(i));
        }

        String sbStr = sb.toString();
        String ff = "";
        if(sbStr.charAt(sbStr.length() -1) == '-'){
            sbStr = sbStr.substring(0, sbStr.length() - 1);
            ff = "-";
        }

        int revx = 0;
        try {
            revx = Integer.valueOf(sbStr);
            if("" != ff){
                revx = -revx;
            }
        }catch (Exception e){
//            e.printStackTrace();
            return 0;
        }
        return revx;
    }

    public static int reverse_2(int x){
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {return 0;}
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {return 0;}
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
