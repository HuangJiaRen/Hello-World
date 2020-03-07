package com.xdf.huangli.leetCode;

import java.util.*;

/**
 * @author huangli
 * @version 1.0
 * @description TODO
 * @date 2020-01-21 16:15
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strArr = {"flower","flow","flight"};
        String s = longestCommonPrefix(strArr);
        System.out.println(s);
    }

    private static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++){
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;


    }
}
