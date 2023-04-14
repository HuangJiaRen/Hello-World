package com.xdf.huangli.leetCode;

import com.alibaba.fastjson.JSON;

/**
 * <p>
 *     59. 螺旋矩阵 II
 *     给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * </P>
 *
 * @author huangli
 * @since 4/14/23 9:25 AM
 */
public class GenerateMatrix {
    public int[][] generateMatrix(int n){
        int maxNum = n * n;
        int curNum = 1;
        int[][] matrix = new int[n][n];
        int row = 0, column = 0;
        //右下左上
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        while(curNum <= maxNum){
            matrix[row][column] = curNum;
            curNum++;
            int nextRow = row + directions[directionIndex][0]
                    , nextColumn = column + directions[directionIndex][1];

            if(nextRow < 0 || nextRow >= n || nextColumn < 0
                    || nextColumn >= n || matrix[nextRow][nextColumn] != 0){
                //顺时针旋转至下一个方向
                directionIndex = (directionIndex + 1) % 4;
            }
            row = row + directions[directionIndex][0];
            column = column + directions[directionIndex][1];
        }
        return matrix;
    }

    public static void main(String[] args) {
        GenerateMatrix generateMatrix = new GenerateMatrix();
        int[][] matrix = generateMatrix.generateMatrix(4);
        System.out.println(JSON.toJSONString(matrix));
    }
}
