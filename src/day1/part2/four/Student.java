package day1.part2.four;

public class Student {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    public void printName(Object greeting){
        if(greeting instanceof String){
            System.out.println(this.name + greeting);
        }
        else{
            throw new MustStringArgumentException("传入的参数必须是String");
        }
    }
}
