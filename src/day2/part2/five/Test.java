package day2.part2.five;

import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {

        Emp[] emps = EmpFactory.getEmps();

        //找出年龄大于30，并输出姓名和年龄
        System.out.println("找出年龄大于30，并输出姓名和年龄");
        Arrays.stream(emps).filter(e -> e.getAge() > 30).forEach(e -> System.out.print(e.getName() + " " + e.getAge() + "/"));
        System.out.println();
        //将薪水修改为薪水加奖金,并输出姓名和修改后的薪水
        System.out.println("将薪水修改为薪水加奖金,并输出姓名和修改后的薪水");
        Arrays.stream(emps).peek(e -> {
            e.setSalary(e.getSalary() + (e.getBonus() == null ? 0 : e.getBonus()));
        }).forEach(x -> System.out.print(x.getName() + " " + x.getSalary() + "/"));
        System.out.println();
        //对薪水排序，并输出薪水
        System.out.println("员工薪水排序:");
        Arrays.stream(emps).map(e -> e.getSalary()).sorted().forEach(e -> System.out.printf("%d ", e));
        System.out.println();
        //找出薪水最大值和最小值，并输出
        LongSummaryStatistics iss = Arrays.stream(emps).mapToLong(e -> e.getSalary()).summaryStatistics();
        System.out.println("员工拿的最高薪水是：" + iss.getMax());
        System.out.println("员工拿的最低薪水是：" + iss.getMin());
        //获取薪水总和和平均值，并输出
        System.out.println("员工拿的总和是：" + iss.getSum());
        System.out.println("员工拿的平均值是：" + iss.getAverage());
        //薪水和奖金的总和，并输出
        long sum = Arrays.stream(emps).mapToLong(e -> e.getSalary() + (e.getBonus() == null ? 0 : e.getBonus())).sum();
        System.out.println("薪水和奖金的总和:" + sum);
    }
}
