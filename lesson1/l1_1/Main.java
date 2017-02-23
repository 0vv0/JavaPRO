package lesson1.l1_1;

import java.lang.reflect.Method;

/**
 * Created by Oleksii.Sergiienko on 2/21/2017.
 */
public class Main {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        Class<?> cls = obj.getClass();
        for(Method m: cls.getDeclaredMethods()){
//            System.out.println(m.getName());
            if(m.isAnnotationPresent(Test.class)) {
                System.out.println(m.getName());
                int a= m.getAnnotation(Test.class).a();
                int b= m.getAnnotation(Test.class).b();

                try {
                    System.out.println(m.invoke(obj,a,b));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
