package day1.part2.three;

public class Test {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.setEngine(new YAMAHA());
        myCar.testEngine();

        myCar.setEngine(new HONDA());
        myCar.testEngine();
    }
}
