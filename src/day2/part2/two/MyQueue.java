package day2.part2.two;

import java.util.ArrayList;
import java.util.Iterator;

public class MyQueue<E> extends ArrayList<E> implements Iterator<E> {


    @Override
    public boolean hasNext() {
       boolean empty = super.isEmpty();
       return !empty;
    }

    @Override
    public E next() {
        return super.remove(0);
    }


    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.add(i);
        }
        while (queue.hasNext()){
            System.out.println(queue.next());
        }
    }
}
