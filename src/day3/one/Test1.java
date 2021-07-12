package day3.one;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class SomeMethod {
    public void a() {
        System.out.println("Invoke Method a()");
    }

    public void NeedParams(int a, int b) {
        System.out.println("a:" + a + " ,b:" + b);
    }

    protected void b() {
        System.out.println("Invoke Method b()");
    }

    private void c() {
        System.out.println("Invoke Method c()");
    }
}

public class Test1 {

    public static void main(String[] args) {
        Class<SomeMethod> clazz = SomeMethod.class;

        try {
            Constructor<SomeMethod> con1 = clazz.getDeclaredConstructor();
            //Constructor<SomeMethod> con2 = clazz.getConstructor();
            Object obj = con1.newInstance();
            Method m1 = clazz.getMethod("a");
            m1.invoke(obj);

            Method m2 = clazz.getMethod("NeedParams", int.class, int.class);
            m2.invoke(obj, 1, 2);

            Method m3 = clazz.getDeclaredMethod("b");
            m3.invoke(obj);

            Method m4 = clazz.getDeclaredMethod("c");
            m4.setAccessible(true);
            m4.invoke(obj);

        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
