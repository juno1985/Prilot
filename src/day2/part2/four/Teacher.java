package day2.part2.four;

public class Teacher implements Comparable<Teacher>{

    private String name;
    private Integer age;
    private Double salary;

    public Teacher(String name, int age) {
        this(name, age, null);
    }

    public Teacher(String name, int age, Double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return name.equals(teacher.name) &&
                age.equals(teacher.age);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public int compareTo(Teacher o) {
        if(this.age < o.getAge()){
            return -1;
        }
        else if(this.age > o.getAge()){
            return 1;
        }
        else{
            if(this.salary < o.getSalary()){
                return -1;
            }
            else if(this.salary > o.getSalary()){
                return 1;
            }
            else{
                return 0;
            }
        }
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
