package evgeny_borisov.spring_patterns.never_use_switch;

import org.springframework.stereotype.Component;

/**
 * @author Sergei Aleshchenko
 */
@Component("3")
public class HappyBirthdayMailGenerator implements MailGenerator {
    @Override
    public String generate(MailInfo mailInfo) {
        return mailInfo.getContent() + "\n happy birthday";
    }

    @Override
    public String getMyCode() {
        return "3";
    }
}
