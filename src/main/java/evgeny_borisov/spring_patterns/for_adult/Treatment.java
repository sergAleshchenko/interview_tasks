package evgeny_borisov.spring_patterns.for_adult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Sergei Aleshchenko
 */
@Retention(RetentionPolicy.RUNTIME)
@Component
@Qualifier
@Autowired
public @interface Treatment {
    String type();
}
