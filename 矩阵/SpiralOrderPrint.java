package com.lsheng.algorithm.matrix;

/**
 * @author zhonglunsheng
 * @Description
 * @create 2018-10-31 16:16
 */
public class SpiralOrderPrint {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        spiralOrderPrint(arr);
    }

    public static void spiralOrderPrint(int[][] arr){
        if (arr == null){
            return;
        }

        // 顶部左上角行坐标点
        int tR = 0;
        // 顶部左上角列坐标点
        int tC = 0;
        // 底部右上角行坐标点
        int dR = arr.length - 1;
        // 底部右上角列坐标点
        int dC = arr[0].length - 1;

        while (tR <= dR && tC <= dC){
            printEdge(arr, tR ++, tC ++, dR --, dC --);
        }

    }

    private static void printEdge(int[][] arr, int tR, int tC, int dR, int dC) {
        // 一列
        if (tR == dR){
            for (int i = tC; i <= dC; i++) {
                System.out.print(arr[tR][i] + " ");
            }
        }else if (tC == dC){
            // 一行
            for (int i = tR; i <= dR; i++) {
                System.out.print(arr[tC][i] + " ");
            }
        }else {
            int curC = tC;
            int curR = tR;
            while (curC != dC){
                System.out.print(arr[tR][curC] + " ");
                curC ++;
            }

            while (curR != dR){
                System.out.print(arr[curR][dC] + " ");
                curR ++;
            }

            while (curC != tC){
                System.out.print(arr[dR][curC] + " ");
                curC --;
            }

            while (curR != tR){
                System.out.print(arr[curR][tC] + " ");
                curR --;
            }
        }
    }
}
