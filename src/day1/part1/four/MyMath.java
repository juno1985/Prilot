package day1.part1.four;

public class MyMath {

    static final double PI = 3.14;

    public double add(double a, double b){
        return a + b;
    }
    public double subtract(double a, double b){
        return a - b;
    }
    public double multiply(double a, double b){
        return a * b;
    }
    public Double divide(double a, double b){
        if(b == 0 ){
            System.out.println("除数不能为零");
            return null;
        }
        return a / b;
    }

    public double roundArea(double r){
        return PI * this.multiply(r, r);
    }
}
