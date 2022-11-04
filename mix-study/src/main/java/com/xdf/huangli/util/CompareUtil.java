package com.xdf.huangli.util;

/**
 * <p>
 *
 * </p>
 *
 * @author lp
 * @since 2021/7/24
 */
public class CompareUtil {

    public static boolean lessThan(Comparable a1 ,Comparable a2){
        return a1.compareTo(a2) == -1;
    }

    public static boolean moreThan(Comparable a1 ,Comparable a2){
        return a1.compareTo(a2) == 1;
    }

    public static boolean beEqualTo(Comparable a1 ,Comparable a2){
        return a1.compareTo(a2) == 0;
    }

    public static boolean moreOrEqual(Comparable a1 ,Comparable a2){
        return a1.compareTo(a2) > -1;
    }

    public static boolean lessOrEqual(Comparable a1 ,Comparable a2){
        return a1.compareTo(a2) < 1;
    }

}
