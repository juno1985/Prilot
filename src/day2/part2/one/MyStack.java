package day2.part2.one;

import java.util.ArrayList;

public class MyStack<E> extends ArrayList<E>{

    public E push(E e){
        super.add(e);
        return e;
    }

    public E poll(){
       return super.remove(super.size() - 1);
    }


    public static void main(String[] args) {

        MyStack<Integer> stack = new MyStack<>();

        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        while (!stack.isEmpty()){
            System.out.println(stack.poll());
        }
    }
}
