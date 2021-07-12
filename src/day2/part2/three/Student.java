package day2.part2.three;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Student {
    private String studentName;
    private Set<Course> course;

    public Student(String name) {
        this.studentName = name;
        this.course = new HashSet<>();
    }

    public void addCourse(Course c){
        this.course.add(c);
    }

    public Course removeCourse(String name){
        Iterator<Course> it = course.iterator();
        while(it.hasNext()){
            Course course = it.next();
            if(course.equals(name)){
                it.remove();
                return course;
            }
        }
        return null;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Set<Course> getCourse() {
        return course;
    }
}
