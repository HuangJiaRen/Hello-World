package com.xdf.huangli.leetCode;

/**
 * <p>
 * 62. 不同路径
 * 相关企业
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 * 示例 1：
 *
 *
 * 输入：m = 3, n = 7
 * 输出：28
 * </P>
 *
 * @author huangli
 * @since 4/18/23 10:15 AM
 */
public class UniquePathsTest {
    public int uniquePaths(int m, int n){
        int[][] f = new int[m][n];
        for (int i = 0; i < m; ++i) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            f[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePathsTest pathsTest = new UniquePathsTest();
        System.out.println(pathsTest.uniquePaths(7, 3));
    }
}
