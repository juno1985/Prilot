package day1.part2.one;

public abstract class Population {
    private Integer lifeBal;
    private Integer attack;
    private Integer occupation;

    public abstract void attack();

    public Integer getLifeBal() {
        return lifeBal;
    }

    public Integer getAttack() {
        return attack;
    }

    public Integer getOccupation() {
        return occupation;
    }

    public void setLifeBal(Integer lifeBal) {
        this.lifeBal = lifeBal;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public void setOccupation(Integer occupation) {
        this.occupation = occupation;
    }
}
