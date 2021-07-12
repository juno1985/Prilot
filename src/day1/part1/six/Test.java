package day1.part1.six;

public class Test {

    public static void main(String[] args) {

        Person male1 = new Person("亚当1", 23, true);
        Person male2 = new Person("亚当2", 23, true);
        Person female = new Person("夏娃", 22, false, male1);

        male2.marry(female);

    }
}
