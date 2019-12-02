package com.xdf.huangli.leetCode;

/**
 * @author huangli
 * @version 1.0
 * @description 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2019-11-26 09:40
 */
public class IsPalindrome {
    public static void main(String[] args) {
        int a = 0;

        boolean palindrome = isPalindrome(a);

        System.out.println(palindrome);
    }

    private static boolean isPalindrome(int a) {
        String str = String.valueOf(a);
        if(str.charAt(0) == '-'){
            return false;
        }

        int aLen = str.length();
        int aMid = 0;
        if(1 != aLen && aLen / 2 == 0){
            aMid = aLen / 2;
        } else {
            aMid = aLen / 2 + 1;
        }

        boolean flg = false;
        for (int i = 0; i < aMid; i++) {
            if(str.charAt(i) == str.charAt(aLen - i - 1)){
                flg = true;
            }else {
                flg = false;
                break;
            }
        }

        return flg;
    }
}
