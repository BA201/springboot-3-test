package Annotation;

import java.lang.annotation.*;
import java.lang.annotation.ElementType;

@Inherited
@Repeatable(he.class)
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.CONSTRUCTOR,
        ElementType.ANNOTATION_TYPE,ElementType.METHOD,ElementType.
        PARAMETER,ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface hi {
    String  value() default "zhang";

}
