package com.leetcode.train;

public class Train_Miashi07 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        matrix = Train_Miashi07.roateMatrix(matrix);
        System.out.println(matrix.toString());
    }

    public static int[][] roateMatrix(int[][] matrix) {
        int rows = matrix.length;
        int[][] matrixNew = matrix;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                matrixNew[j][rows - i - 1] = matrix[i][j];
            }
        }
        matrix = matrixNew;
        return matrix;
    }
}
