package OtherLesson41;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // можем использовать только на методах
@Retention(RetentionPolicy.RUNTIME) // политика удержания, сохраняется в байт-коде и доступна во время работы программы
public @interface MethodInfo {
    String author() default "Evgeniy"; //default - значение по умолчанию
    int dateOfCreation() default 2022;
    String purpose();
}
