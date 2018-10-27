package com.lsheng.algorithm.stackandqueue;

/**
 * @author zhonglunsheng
 * @Description 通过数组来实现栈   方法push/pop/peek
 * @create 2018-10-27 23:56
 */
public class ArrayStack {

    private Integer[] arr;
    private Integer size;

    public ArrayStack(int initSize){
        if (initSize < 0){
            throw new IllegalArgumentException("The init size is less than 0");
        }
        arr = new Integer[initSize];
        size = 0;
    }

    public Integer peek(){
        if (size == 0){
            return null;
        }
        return arr[size];
    }

    public void push(int obj){
        if (size == arr.length){
            throw new ArrayIndexOutOfBoundsException("The stack is full");
        }
        arr[size++] = obj;
    }

    public Integer pop(){
        if (size == 0){
            throw new ArrayIndexOutOfBoundsException("The stack is empty");
        }
        return arr[--size];

    }

}
