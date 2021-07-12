package day2.part2.three;

import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Student student1 = new Student("student1");
        Student student2 = new Student("student2");
        Student student3 = new Student("student3");

        Course course1 = new Course("Math");
        Course course2 = new Course("Art");
        Course course3 = new Course("English");
        Course course4 = new Course("Yoga");

        student1.addCourse(course1);
        student1.addCourse(course2);

        student2.addCourse(course1);
        student2.addCourse(course3);

        student3.addCourse(course1);
        student3.addCourse(course2);
        student3.addCourse(course4);

        SchoolClass schoolClass = new SchoolClass();
        schoolClass.addStudent(student1);
        schoolClass.addStudent(student2);
        schoolClass.addStudent(student3);

        int sum = 0;
        String courseName = "Math";
        Set<Student> studentSet = schoolClass.getStudent();
        for(Student s : studentSet){
            Set<Course> courseSet = s.getCourse();
            for(Course c : courseSet){
                if(c.getCourseName().equals(courseName)){
                    sum++;
                }
            }
        }
        System.out.println(courseName + ":" + sum);
    }
}
