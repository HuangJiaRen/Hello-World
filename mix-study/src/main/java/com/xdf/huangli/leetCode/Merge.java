package com.xdf.huangli.leetCode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <p>
 *
 * </P>
 *
 * @author huangli
 * @since 4/7/23 2:53 PM
 */
public class Merge {
    public int[][] merge(int[][] intervals){
        if(intervals.length == 0){
            return new int[0][2];
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });

        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0], R = intervals[i][1];
            if(merged.size() == 0 || merged.get(merged.size() - 1)[1] < L){
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1] , R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] merge1 = merge.merge(intervals);
        System.out.println(JSON.toJSONString(merge1));
    }
}
