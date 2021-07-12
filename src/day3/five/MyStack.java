package day3.five;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyStack<E> extends LinkedList<E> {


    private final Object lock = new Object();


    private LinkedList<E> list;

    public MyStack() {
        this.list = new LinkedList<>();
    }

    public void put(E e) throws InterruptedException {
        synchronized (lock) {
            this.list.add(e);
            lock.notify();
        }


    }

    public E take() throws InterruptedException {

        E e = null;
        synchronized (lock) {
            while (this.list.size() == 0) {
                lock.wait();
            }
            e = this.list.removeLast();

        }
        return e;
    }

}

class Test {
    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    myStack.put(i);
                    System.out.println(Thread.currentThread().getName() + " add " + i);
                    //放1秒
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    Integer e = myStack.take();
                    System.out.println(Thread.currentThread().getName() + " take " + e);
                    //取0.5秒
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}