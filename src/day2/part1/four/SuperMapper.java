package day2.part1.four;


import java.util.ArrayList;

public interface SuperMapper<T, U> {
    U map(T val);
}

class SuperMapperList<T> extends ArrayList<T> {
    public <U> SuperMapperList<U> map(SuperMapper<T, U> mapper) {
        SuperMapperList<U> res = new SuperMapperList<U>();
        for (T val : this) {
            res.add(mapper.map(val));
        }
        return res;
    }
}

class SuperMapperTest {

    public static void main(String[] args) {
        SuperMapperList<Integer> sml = new SuperMapperList<Integer>();

        for (int i = 1; i <= 5; i++) {
            sml.add(i);
        }

        SuperMapperList<String> res;

        res = sml.map((a) -> {
            return "String " + a;
        });
        System.out.println(res);
    }
}
