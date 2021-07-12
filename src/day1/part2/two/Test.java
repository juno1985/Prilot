package day1.part2.two;

public class Test {

    public static void main(String[] args) {
        Weapon tank = new Tank();
        Weapon flighter = new Flighter();
        Weapon missle = new MissileTurret();

        Army army = new Army(3);
        army.addWeapon(tank);
        army.addWeapon(flighter);
        army.addWeapon(missle);

        army.attackAll();
        army.moveAll();

    }
}
