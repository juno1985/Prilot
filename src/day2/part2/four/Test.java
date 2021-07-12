package day2.part2.four;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Test {

    public static void main(String[] args) {
        Teacher teacher1 = new Teacher("t1", 30, 9000.00);
        Teacher teacher2 = new Teacher("t1", 30, 9000.00);
        Teacher teacher3 = new Teacher("t2", 20, 9900.99);

        Set<Teacher> set = new HashSet<>();
        set.add(teacher1);
        set.add(teacher2);
        set.add(teacher3);
        // print 2 - 因为1，2相同
        System.out.println(set.size());

        Set<Teacher> sortSet = new TreeSet<>();
        sortSet.add(teacher1);
        sortSet.add(teacher2);
        sortSet.add(teacher3);
        Iterator<Teacher> it = sortSet.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
