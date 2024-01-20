package evgeny_borisov.spring_patterns.never_use_switch;

import org.springframework.stereotype.Component;

/**
 * @author Sergei Aleshchenko
 */
@Component("2")
public class EmailCallbackMailGenerator implements MailGenerator {
    @Override
    public String generate(MailInfo mailInfo) {
        return mailInfo.getContent() + "\n don't call us Nikolas";
    }

    @Override
    public String getMyCode() {
        return "2";
    }
}
