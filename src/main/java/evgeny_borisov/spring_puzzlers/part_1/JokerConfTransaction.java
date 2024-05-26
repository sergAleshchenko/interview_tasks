package evgeny_borisov.spring_puzzlers.part_1;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Sergei Aleshchenko
 */
@Retention(RetentionPolicy.RUNTIME)
@Transactional
public @interface JokerConfTransaction {
    Propagation propagation() default Propagation.REQUIRES_NEW;
}
