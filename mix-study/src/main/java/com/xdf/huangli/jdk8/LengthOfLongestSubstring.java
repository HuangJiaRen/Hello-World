package com.xdf.huangli.jdk8;

import com.google.common.collect.Maps;

import java.util.HashMap;

/**
 * @author huangli
 * @version 1.0
 * @description TODO
 * @date 2019-10-22 10:07
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "fdfdsee";
        int res = lengthOfLongestSubstring(s);
        int res_2 = lengthOfLongestSubstring_2(s);
        System.out.println(res);
        System.out.println(res_2);
    }

    private static int lengthOfLongestSubstring_2(String s) {
        int n = s.length(), ans = 0;
        HashMap<Character, Integer> map = Maps.newHashMap();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)){
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }

        return ans;
    }

    private static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        char[] chars = s.toCharArray();
        int leftIndex = 0;
        for (int j = 0; j < chars.length; j++) {
            for (int innerIndex = leftIndex; innerIndex < j; innerIndex++) {
                if (chars[innerIndex] == chars[j]) {
                    maxLength = Math.max(maxLength, j - leftIndex);
                    leftIndex = innerIndex + 1;
                    break;
                }
            }
        }
        return Math.max(chars.length - leftIndex, maxLength);
    }

}
