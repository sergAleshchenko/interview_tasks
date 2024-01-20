package evgeny_borisov.spring_patterns.never_use_switch;

import org.springframework.stereotype.Component;

/**
 * @author Sergei Aleshchenko
 */
@Component("1")
public class WelcomeMailGenerator implements MailGenerator {
    @Override
    public String generate(MailInfo mailInfo) {
        // 30 lines code
        return mailInfo.getContent() + "\n welcome mail";
    }

    @Override
    public String getMyCode() {
        return "1";
    }
}
