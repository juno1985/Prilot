package day3.four;

public class Test {

    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
            for (int i = 1; i <= 26; i++) {
                System.out.println(Thread.currentThread().getName() + "-->" + i);
            }
        });

        Thread thread2 = new Thread(()->{
            for(char i = 'a'; i <= 'z'; i++){
                System.out.println(Thread.currentThread().getName() + "-->" + i);
            }
        });

        thread1.start();
        thread2.start();
    }
}
