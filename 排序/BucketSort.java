package com.lsheng.algorithm.sort;

import java.util.Arrays;

/**
 * @author zhonglunsheng
 * @Description
 * @create 2018-10-27 22:32
 */
public class BucketSort {

    public static void main(String[] args) {
        int[] arr = new int[25];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 10 + Math.random() * 20 + 32);
        }
        bucketSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bucketSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        // value 0~200
        int[] bucket = new int[max + 1];

        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]] ++;
        }

        int index = 0;
        for (int j = 0; j < bucket.length; j++) {
            while (bucket[j]-- > 0){
                arr[index++] = j;
            }
        }

    }
}
