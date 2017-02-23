package lesson1.l1_3;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Oleksii.Sergiienko on 2/21/2017.
 */
public class Main {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException,
            NoSuchMethodException, InstantiationException, NoSuchFieldException {

        SClass myClass = new SClass();
        System.out.println("default: " + myClass);

        myClass.set(0,0,0,"",false);
        String s = Serializer.serialize(myClass);
        System.out.println("serialized: " + myClass);
//        System.out.println("serialized string: " + s);

        myClass = Serializer.deserialize(s, myClass.getClass());
        System.out.println("deserialized: " + myClass);

    }

}
