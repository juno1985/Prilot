package day2.part2.three;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SchoolClass {

    private Set<Student> student;

    public SchoolClass() {
        this.student = new HashSet<>();
    }

    public void addStudent(Student s){
        this.student.add(s);
    }

    public Student removeStudent(String name){
        Iterator<Student> it = student.iterator();
        while(it.hasNext()){
            Student s = it.next();
            if(s.getStudentName().equals(name)){
                it.remove();
                return s;
            }
        }
        return null;
    }

    public Set<Student> getStudent() {
        return student;
    }
}
