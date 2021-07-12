package day1.part1.five;

public class Bird extends Animal {

    public Bird(String name) {
        this.setLegs(2);
        this.setName(name);
    }

    @Override
    public void move() {
        System.out.println(this.getName() + " Flying!");
    }
}
