package com.mooc.house.biz.sort;

import java.util.Arrays;

/**
 * @author zhonglunsheng
 * @create 2018-10-22 18:25
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = 5 + (int)(Math.random() * 10 + Math.random() * 100);
        }
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        mergeSort(arr, 0, arr.length-1);
    }

    public static void mergeSort(int[] arr, int l, int r){
        if (l == r){
            return;
        }

        int m = l + (r - l) / 2;

        mergeSort(arr, l, m);
        mergeSort(arr, m+1, r);


        merge(arr, l , m, r);

    }

    private static void merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p = l;
        int q = m + 1;
        while(p <= m && q <= r){
            help[i++] = arr[p] > arr[q] ? arr[q++] : arr[p++];
        }

        while(p <= m){
            help[i++] = arr[p++];
        }

        while (q <= r){
            help[i++] = arr[q++];
        }

        for (int j = 0; j < help.length; j++) {
            arr[l + j] = help[j];
        }


    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

