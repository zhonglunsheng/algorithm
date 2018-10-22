package com.mooc.house.biz.sort;

import java.util.Arrays;

/**
 *
 * @author zhonglunsheng
 * @create 2018-10-22 16:57
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,5,1,4,8};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        int count = 0;
        for (int i = arr.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[j+1]){
                    count ++;
                    swap(arr, j, j+1);
                }
            }
            if (count == 0){
                break;
            }
        }
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
