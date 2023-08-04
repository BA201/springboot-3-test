package Annotation;

import java.lang.annotation.*;

@Inherited
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.CONSTRUCTOR,
        ElementType.ANNOTATION_TYPE,ElementType.METHOD,ElementType.
        PARAMETER,ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface he {

    hi[] value() ;

}
