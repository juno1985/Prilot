package day3.two;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

class ExampleClass {
    public String Str;
    public int Number;
}
public class Test {
    public static void main(String[] args) {
        Class<ExampleClass> clazz = ExampleClass.class;
        try {
            Object obj = clazz.getDeclaredConstructor().newInstance();
            Field fieldStr = clazz.getField("Str");
            Field fieldNumber = clazz.getField("Number");
            fieldStr.set(obj, "test");
            fieldNumber.setInt(obj, 100);
            System.out.println(fieldStr.get(obj));
            System.out.println(fieldNumber.get(obj));
        } catch (NoSuchFieldException | IllegalAccessException | InstantiationException| NoSuchMethodException |InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
