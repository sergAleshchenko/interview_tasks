package evgeny_borisov.epam;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Sergei Aleshchenko
 */
@Retention(RUNTIME)
public @interface InjectProperty {
    String value() default "";
}
