package day1.part2.one;

public class CommandCenter extends Building {
    @Override
    public Population create() {
        Farmer farmer = new Farmer();
        farmer.setAttack(1);
        farmer.setLifeBal(10);
        farmer.setOccupation(1);
        return farmer;
    }
}
