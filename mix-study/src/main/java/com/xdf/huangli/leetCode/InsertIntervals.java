package com.xdf.huangli.leetCode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </P>
 *
 * @author huangli
 * @since 4/10/23 11:06 AM
 */
public class InsertIntervals {
    public int[][] insert(int[][] intervals, int[] newInterval){
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> ansList = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            if(interval[0] > right){
                // 在插入区间的右侧且无交集
                if(!placed){
                    ansList.add(new int[]{left, right});
                    placed = true;
                }
                ansList.add(interval);
            }else if(interval[1] < left){
                //在插入区间的左侧且无交集
                ansList.add(interval);
            } else {
                // 与插入区间有交集，计算它们的并集
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if(!placed){
            ansList.add(new int[]{left, right});
        }
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); ++i) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        InsertIntervals ints = new InsertIntervals();
        int[][] intervals = {{1,3},{6,9}};
        int[] newIntervals = {2, 5};
        int[][] insert = ints.insert(intervals, newIntervals);
        System.out.println(JSON.toJSONString(insert));
    }
}
