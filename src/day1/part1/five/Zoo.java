package day1.part1.five;

public class Zoo {

    public static void main(String[] args) {
        Animal animal = new Animal("animal", 4);
        Fish fish = new Fish("fish");
        Bird bird = new Bird("bird");

        animal.move();
        fish.move();
        bird.move();
    }
}
