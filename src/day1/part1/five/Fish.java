package day1.part1.five;

public class Fish extends Animal {

    public Fish(String name) {
        this.setName(name);
        this.setLegs(0);
    }

    @Override
    public void move() {
        System.out.println(this.getName() + "Swimming!");
    }
}
