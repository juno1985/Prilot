package day2.part1.one;
public class SuperMath {

    //类型需要实现Comparable接口
    public static <T extends Comparable<T>> T getMax(T[] arr){
        T max = arr[0];
        for(T t : arr){
            if(max.compareTo(t) < 0){
                max = t;
            }
        }
        return max;
    }

    public static <T extends Comparable<T>> T getMin(T[] arr){
        T min = arr[0];
        for(T t : arr){
            if(min.compareTo(t) > 0){
                min = t;
            }
        }
        return min;
    }
}
