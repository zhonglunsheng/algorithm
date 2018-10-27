package com.lsheng.algorithm.sort;

import java.util.Arrays;

/**
 * @author zhonglunsheng
 * @Description
 * @create 2018-10-27 23:08
 */
public class MaxGap {

    public static void main(String[] args) {
        int[] arr = new int[25];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 10 + Math.random() * 120 + 32);
        }
        System.out.println(maxGap(arr));
    }

    public static int maxGap(int[] arr){
        if (arr == null || arr.length < 2){
            return 0;
        }

        int len = arr.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        boolean[] hasNum = new boolean[len + 1];
        int[] mins = new int[len + 1];
        int[] maxs = new int[len + 1];

        int bid = 0;
        for (int i = 0; i < len; i++) {
            bid = bucket(arr[i], len, max, min);
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], arr[i] ) : arr[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], arr[i] ) : arr[i];
            hasNum[bid] = true;
        }

        int res = 0;
        int lastMax = maxs[0];
        for (int i = 1; i < arr.length; i++) {
            if (hasNum[i]){
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    private static int bucket(long num, long len, long max, long min) {
        return (int)((num - min) * len / (max - min));
    }
}
