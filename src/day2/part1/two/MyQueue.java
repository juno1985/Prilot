package day2.part1.two;

import java.util.Arrays;

public class MyQueue<T> {

    private Object[] array = {};
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    public MyQueue() {
        this.array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public <T> T poll(){
        if(size == 0){
            throw new RuntimeException("队列中没有元素");
        }
        T first = (T)array[0];
        int numMoved = size - 1;
        if (numMoved > 0)
            System.arraycopy(array, 1, array, 0,
                    numMoved);
        array[--size] = null; // clear
        return first;

    }

    public <T> T offer(T t){

        if(size >= array.length - 1){
            //扩充1.5倍
            int newCapacity = array.length + (array.length >> 1);
            //超出int范围
            if(newCapacity < 0){
                throw new OutOfMemoryError();
            }
            array = Arrays.copyOf(array, newCapacity);
        }
        array[size++] = t;
        return t;
    }
}
