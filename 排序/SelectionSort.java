package com.mooc.house.biz.sort;

import java.util.Arrays;

/**
 * @author zhonglunsheng
 * @create 2018-10-22 17:12
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,5,1,4,8};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void selectSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }

        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex]? j:minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
