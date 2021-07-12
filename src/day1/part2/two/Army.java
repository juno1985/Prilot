package day1.part2.two;

public class Army {

    Weapon[] w;
    int index;

    public Army(int max) {
        w = new Weapon[max];
        index = 0;
    }

    public void addWeapon(Weapon wp){
        this.w[index++] = wp;
    }

    public void attackAll(){
        for(Weapon wp : this.w){
            wp.attack();
        }
    }

    public void moveAll(){
        for(Weapon wp : this.w){
           if( wp instanceof Mobile){
               ((Mobile)wp).move();
           }
        }
    }
}
