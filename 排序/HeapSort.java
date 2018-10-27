package com.lsheng.algorithm.sort;

import java.util.Arrays;

/**
 * @author zhonglunsheng
 * @Description
 * @create 2018-10-27 13:18
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 10 + Math.random() * 20 + 32);
        }
        heapSort(arr);
    }

    public static void heapSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }

        for (int index = 0; index < arr.length; index++) {
            heapInsert(arr, index);
        }
        int size = arr.length;
        swap(arr, 0, --size);

        while(size > 0){
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }


    }

    public static void heapInsert(int[] arr, int index) {
        while(arr[index] > arr[(index -1) / 2]){
            swap(arr, index, (index-1) /2);
            index = (index -1) / 2;
        }
    }

    public static void heapify(int[] arr, int index, int size){
        int left = index * 2 + 1;
        while(left < size){
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index){
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }


    public static void swap(int[] arr, int source, int target){
        int temp = arr[source];
        arr[source] = arr[target];
        arr[target] = temp;
    }
}
