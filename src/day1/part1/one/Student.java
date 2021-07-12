package day1.part1.one;

public class Student {

    private String name;
    private String no;
    private int age;

    public Student(String name, String no, int age) {
        this.name = name;
        this.no = no;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", no='" + no + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        Student student = new Student("Alex", "1234567", 30);
        System.out.println(student.toString());
    }
}
