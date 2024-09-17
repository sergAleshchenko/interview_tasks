package selenium_express.spring_27_questions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Sergei Aleshchenko
 */
@Component
@Getter
@Setter
public class SpelBean {

    @Value("#{T(selenium_express.spring_27_questions.SpelClass).NAME}")
    private String loadValueFromAStaticMember;

    @Value("#{T(selenium_express.spring_27_questions.SpelClass).staticMethod()}")
    private String loadValueFromStaticMethod;

    public void printFields() {
        System.out.println(loadValueFromAStaticMember);
        System.out.println(loadValueFromStaticMethod);
    }

}
