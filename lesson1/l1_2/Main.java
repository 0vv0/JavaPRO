package lesson1.l1_2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Oleksii.Sergiienko on 2/21/2017.
 */
public class Main {
    public static void main(String[] args) {
        TextContainer tc = new TextContainer();
        tc.text = "12345";


        Class<?> cls = tc.getClass();
        if(cls.isAnnotationPresent(SaveTo.class)){
            String path = cls.getAnnotation(SaveTo.class).path();
            for(Method m:cls.getDeclaredMethods()){
                if(m.isAnnotationPresent(Saver.class)){
                    try {
                        m.invoke(tc, path);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
