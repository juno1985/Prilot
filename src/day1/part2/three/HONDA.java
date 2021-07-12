package day1.part2.three;

public class HONDA implements IEngine{
    @Override
    public void start() {
        System.out.println("HONDA启动，速度40");
    }

    @Override
    public void stop() {
        System.out.println("HONDA停止，速度0");
    }

    @Override
    public void speedUp() {
        System.out.println("HONDA加速，速度120");
    }
}
