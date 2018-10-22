package com.mooc.house.biz.sort;

import java.util.Arrays;

/**
 * @author zhonglunsheng
 * @create 2018-10-22 18:04
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = new int[20];
        for (int i = 0; i < 20; i++) {
            arr[i] = 5 + (int)(Math.random() * 10 + Math.random() * 100);
        }
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    public static void insertSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j >0 && arr[j] < arr[j-1] ; j--) {
                    swap(arr, j, j-1);
            }
        }
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
