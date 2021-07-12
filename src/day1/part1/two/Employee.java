package day1.part1.two;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class Employee {

    private String name;
    private double basePay;
    private double bonus;
    private double taxRate;

    public Employee(String name, double basePay, double bonus, double taxRate) {
        this.name = name;
        this.basePay = basePay;
        this.bonus = bonus;
        this.taxRate = taxRate;
    }

    private void calculateSalary(){
        double salary = (this.basePay + this.bonus) * taxRate;
        System.out.println(this.name + "，当月实发薪水为 " + salary);
    }

    public static void main(String[] args) {
        Employee employee = new Employee("Alex", 8888.88 , 2222.22, 0.9);
        employee.calculateSalary();
    }
}
