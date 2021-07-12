package day1.part2.three;

public class Car {
    IEngine engine;

    void testEngine(){
        this.engine.start();
        this.engine.speedUp();
        this.engine.stop();
    }

    public void setEngine(IEngine engine) {
        this.engine = engine;
    }
}
