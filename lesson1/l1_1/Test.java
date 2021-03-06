package lesson1.l1_1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Oleksii.Sergiienko on 2/21/2017.
 */
@Target(value = ElementType.METHOD)
@Retention(value= RetentionPolicy.RUNTIME)
public @interface Test {
    int a() default 0;
    int b() default 0;
}
