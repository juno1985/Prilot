package day1.part1.six;

public class Person {

    public String name;
    public int age;
    /**
     * true - male
     * false - female
     */
    public boolean gender;
    public Person partner;

    public Person(String name, int age, boolean gender) {
        this(name, age, gender, null);
    }

    public Person(String name, int age, boolean gender, Person partner) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.partner = partner;
    }

    public void marry(Person p) {
        if (this.gender == p.gender) {
            System.out.println("同性不能结婚");
            return;
        } else if (this.partner != null || p.partner != null) {
            System.out.println("已婚不能结婚");
            return;
        } else {
            //本对象是男
            if (this.gender) {
                if (this.age < 22) {
                    System.out.println("男性不能小于22岁");
                    return;
                } else if (p.age < 20) {
                    System.out.println("女性不能小于20岁");
                    return;
                }
            }
            //本对象是女
            else {
                if (this.age < 20) {
                    System.out.println("女性不能小于20岁");
                    return;
                } else if (p.age < 22) {
                    System.out.println("男性不能小于22岁");
                    return;
                }
            }
            System.out.println("恭喜结婚");
        }
    }
}
