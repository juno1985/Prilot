package day1.part2.two;

public class Flighter extends Weapon implements Mobile{
    @Override
    public void attack() {
        System.out.println("Flighter is attacking: " + this);
    }

    @Override
    public void move() {
        System.out.println("Flighter is moving: " + this);
    }
}
