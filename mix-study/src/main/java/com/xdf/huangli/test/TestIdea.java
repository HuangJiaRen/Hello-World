package com.xdf.huangli.test;

import java.util.ArrayList;
import java.util.List;

//import static sun.swing.MenuItemLayoutHelper.max;

/**
 * @author huangli
 * @version 1.0
 * @description TODO
 * @date 2020-10-26 14:31
 */
public class TestIdea {
    /**
     * 两个数组：数组1：有序，数组2，找出交集元素
     * @param args
     */
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9};
        int[] b = {3, 5, 7};
        int[] numArr = findSameNumArr(a, b);
        System.out.println("");

        int[] c = {1, 2, 3, -1, 9, 8, 7, 0};
        int maxSum = findMaxSum(c);
        System.out.println(maxSum);
    }

    private static int findMaxSum(int[] c) {
        int maxTmp = 0;
        int maxNow = 0;
//        for(int i = 0; i < c.length; i++){
//            maxNow = max(maxNow + c[i], 0);
//            maxTmp = max(maxTmp, maxNow);
//        }

        return maxTmp;
    }

    private static int[] findSameNumArr(int[] a, int[] b) {
        if(null == a || a.length == 0
            || null == b || b.length == 0){
            return null;
        }


        List<Integer> list = new ArrayList<Integer>();
        int ptA = 0;
        int ptB = 0;
        while (ptA < a.length && ptB < b.length){
            if(a[ptA] < b[ptB]){
                ptA ++;
            } else if(a[ptA] > b[ptB]){
                ptB ++;
            } else {
                list.add(a[ptA]);
                ptA ++;
                ptB ++;
            }
        }

        if(null == list || list.size() == 0){
            return null;
        }

        int[] resArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            resArr[i] = list.get(i);
        }

        return resArr;
    }


}
