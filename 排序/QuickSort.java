package com.mooc.house.biz.sort;

import java.util.Arrays;

/**
 * @author zhonglunsheng
 * @create 2018-10-22 22:43
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = 5 + (int)(Math.random() * 10 + Math.random() * 100);
        }
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }

        quickSort(arr, 0, arr.length-1);
    }

    private static void quickSort(int[] arr, int l, int r) {
        if (l < r){
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }


    }

    public static int[] partition(int[] arr, int l, int r){
        int less = l -1;
        int more = r;
        while (l < more){
            if (arr[l] < arr[r]){
                swap(arr, ++less, l++);
            }else if (arr[l] > arr[r]){
                swap(arr, --more, l);
            }else{
                l++;
            }
        }
        swap(arr, more, r);
        return new int[]{less + 1, more};
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
