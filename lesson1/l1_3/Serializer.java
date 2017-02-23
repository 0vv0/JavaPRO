package lesson1.l1_3;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Oleksii.Sergiienko on 2/21/2017.
 */
public class Serializer {
    private static Map<Class, Class> converter = new HashMap();

    static {
        converter.put(byte.class, Byte.class);
        converter.put(char.class, Character.class);
        converter.put(int.class, Integer.class);
        converter.put(long.class, Long.class);
        converter.put(float.class, Float.class);
        converter.put(double.class, Double.class);
        converter.put(boolean.class, Boolean.class);
        converter.put(short.class, Short.class);
        converter.put(void.class, Void.class);
    }

    public static String serialize(Object obj) throws IllegalAccessException {
        assert obj != null;
        StringBuilder result = new StringBuilder();
        List<Field> fields = new ArrayList<>();
        for (Field f : obj.getClass().getDeclaredFields()) {
            if (!f.isAnnotationPresent(Save.class)) {
                continue;
            }
            boolean flag = f.isAccessible();
            f.setAccessible(true);
            result.append(f.getName());
            result.append("=");
            result.append(f.get(obj).toString());
            result.append("\n");
            f.setAccessible(flag);
        }
        return result.toString();
    }

    static <T> T deserialize(String objString, Class<T> tClass)
            throws IllegalAccessException, InstantiationException, NoSuchFieldException,
            NoSuchMethodException, InvocationTargetException {
        T obj = tClass.newInstance();
        String[] arr = objString.split("\n");
        for (int i = 0; i < arr.length; i++) {
            String name = arr[i].split("=")[0];
            String value = arr[i].split("=")[1];
            Field f = tClass.getDeclaredField(name);
            boolean flag = f.isAccessible();
            f.setAccessible(true);
//          wrap primitive into Object class
            Class<?> t = f.getType().isPrimitive() ? converter.get(f.getType()) : f.getType();
            //try to use Class<?>.valueOf(String s) to convert from String to Field Type
            f.set(obj, t.getDeclaredMethod("valueOf", String.class).invoke(t, value));
            f.setAccessible(flag);
        }
        return obj;
    }
}
