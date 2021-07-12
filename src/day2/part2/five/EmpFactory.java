package day2.part2.five;

class Emp{
    // 编号
    private Integer no;
    // 姓名
    private String name;
    // 年龄
    private Integer age;
    // 职位
    private String job;
    // 薪水
    private Integer salary;
    // 奖金
    private Integer bonus;
    // 部门
    private String dept;

    public Emp(Integer no, String name, Integer age, String job, Integer salary, Integer bonus, String dept){
        this.no = no;
        this.name = name;
        this.age = age;
        this.job = job;
        this.salary = salary;
        this.bonus = bonus;
        this.dept = dept;
    }

    public String toString(){
        return name;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}

public class EmpFactory{
    private static Emp[] emps = new Emp[]{
            new Emp(7369, "SMITH", 28, "CLERK", 3000, null, "RESEARCH"),
            new Emp(7499, "ALLEN", 24, "SALESMAN", 4000, 300, "SALES"),
            new Emp(7521, "WARD", 30, "SALESMAN", 2500, 500, "SALES"),
            new Emp(7566, "JONES", 32, "MANAGER", 5000, null, "RESEARCH"),
            new Emp(7654, "MARTIN", 27, "SALESMAN", 2800, 1400, "SALES"),
            new Emp(7698, "BLAKE", 35, "MANAGER", 4500, null, "SALES"),
            new Emp(7782, "CLARK", 29, "MANAGER", 4300, null, "ACCOUNTING"),
            new Emp(7788, "SCOTT", 38, "ANALYST", 6000, null, "RESEARCH"),
            new Emp(7839, "KING", 40, "PRESIDENT", 8000, null, "ACCOUNTING")
    };

    public static Emp[] getEmps(){
        return emps;
    }
}