package day2.part1.three;

@FunctionalInterface
public interface MyMath {
    int ops(int a, int b);
}

class MyMathTest {

    public static int calculate(int a, int b, MyMath myMath) {
        return myMath.ops(a, b);
    }

    public static void main(String[] args) {

        System.out.println(calculate(1, 2, (a, b) -> a + b));
        System.out.println(calculate(2, 1, (a, b) -> a - b));
        System.out.println(calculate(2, 3, (a, b) -> a * b));
        System.out.println(calculate(4, 2, (a, b) -> a / b));
    }
}
