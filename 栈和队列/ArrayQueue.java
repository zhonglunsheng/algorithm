package com.lsheng.algorithm.stackandqueue;

/**
 * @author zhonglunsheng
 * @Description 数组实现队列 方法：push/poll/peek
 * @create 2018-10-28 0:09
 */
public class ArrayQueue {

    private Integer[] arr;
    private Integer size;
    private Integer end;
    private Integer start;


    public ArrayQueue(int initSize){
        if (initSize < 0){
            throw new IllegalArgumentException("the init size is less than 0");
        }
        arr = new Integer[initSize];
        size = 0;
        end = 0;
        start = 0;
    }

    public void push(Integer obj){
        if (size == arr.length){
            throw new ArrayIndexOutOfBoundsException("the queue is full");
        }
        arr[end] = obj;
        size ++;
        end = end == arr.length - 1 ? 0 : end ++;
    }

    public Integer poll(){
        if (size == 0){
            throw new ArrayIndexOutOfBoundsException("the queue is empty");
        }
        size --;
        int temp = start;
        start = start == arr.length - 1 ? 0 : start ++;
        return arr[temp];
    }

    public Integer peek(){
        if (size == 0){
            return null;
        }

        return arr[start];
    }

}
