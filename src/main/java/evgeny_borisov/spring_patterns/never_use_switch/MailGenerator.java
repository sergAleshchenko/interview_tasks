package evgeny_borisov.spring_patterns.never_use_switch;

/**
 * @author Sergei Aleshchenko
 */
public interface MailGenerator {
    String generate(MailInfo mailInfo);

    String getMyCode();
}
