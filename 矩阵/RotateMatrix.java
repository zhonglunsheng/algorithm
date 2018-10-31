package com.lsheng.algorithm.matrix;

/**
 * @author zhonglunsheng
 * @Description
 * @create 2018-10-31 17:27
 */
public class RotateMatrix {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotateMatrix(arr);
    }

    public static void rotateMatrix(int[][] matrix){
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;

        while(tR < dR){
            rotateEdge(matrix, tR ++, tC ++, dR --, dC --);
        }

        printMatrix(matrix);

    }

    private static void rotateEdge(int[][] matrix, int tR, int tC, int dR, int dC) {
        int times = dC - tC;
        int temp;
        for (int i = 0; i < times; i++) {
            temp = matrix[tR][tC + i];
            matrix[tR][tC + i] = matrix[dR - i][tC];
            matrix[dR - i][tC] = matrix[dR][dC - i];
            matrix[dR][dC - i] = matrix[tR + i][dC];
            matrix[tR + i][dC] = temp;
        }
    }

    private static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
