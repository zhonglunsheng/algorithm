package com.lsheng.algorithm.matrix;

/**
 * @author zhonglunsheng
 * @Description
 * @create 2018-10-31 18:19
 */
public class ZigZagPrintMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        zigZagPrintMatrix(matrix);
    }

    public static void zigZagPrintMatrix(int[][] matrix){
        if (matrix == null){
            return;
        }

        int tR = 0;
        int tC = 0;
        int dR = 0;
        int dC = 0;
        int endR = matrix.length -1;
        int endC = matrix[0].length -1;
        boolean fromUp = false;

        while(tR != endR + 1){
            printLevel(matrix, tR, tC, dR, dC, fromUp);
            tR = tC == endC ? tR + 1 : tR;
            tC = tC == endC ? tC : tC + 1;
            dC = dR == endR ? dC + 1 : dC;
            dR = dR == endR ? dR : dR + 1;
            fromUp = ! fromUp;
        }
    }

    private static void printLevel(int[][] matrix, int tR, int tC, int dR, int dC, boolean fromUp) {
        if (fromUp){
            while (tR != dR + 1){
                System.out.print(matrix[tR ++][tC --] + " ");
            }
        }else{
            while (dR != tR - 1){
                System.out.print(matrix[dR --][dC ++] + " ");
            }
        }
    }
}
