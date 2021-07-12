package day1.part1.three;

public class Animal {
    private String name;
    private int legs;

    public Animal() {
       this("AAA", 4);
    }

    public Animal(String name, int legs) {
        this.name = name;
        this.legs = legs;
    }

    public void move(){
        System.out.println(this.name + " is Moving!");
    }

    public void move(int n){
        System.out.println(this.name + "is Moving " + n + "米");
    }


}
