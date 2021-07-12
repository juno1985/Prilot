package day1.part2.two;

public class Tank extends Weapon implements Mobile{
    @Override
    public void attack() {
        System.out.println("Tank is attacking: " + this);
    }

    @Override
    public void move() {
        System.out.println("Tank is moving: " + this);
    }
}
