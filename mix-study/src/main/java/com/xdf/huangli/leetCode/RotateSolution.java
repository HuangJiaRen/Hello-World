package com.xdf.huangli.leetCode;

import cn.hutool.json.JSONObject;

/**
 * <p>
 *
 * </P>
 *
 * @author huangli
 * @since 2022-10-10 09:10
 */
public class RotateSolution {
    public static void main(String[] args) {
        int[][] matrix = {{5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16}};
        int[][] rotate = rotate(matrix);
    }

    public static int[][] rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] matrix_new = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix_new[j][n - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = matrix_new[i][j];
            }
        }

        return matrix;
    }
}
