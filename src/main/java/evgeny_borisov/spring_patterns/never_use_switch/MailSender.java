package evgeny_borisov.spring_patterns.never_use_switch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Sergei Aleshchenko
 */
@Service
public class MailSender {
    private Map<String, MailGenerator> map;

    public void send(MailInfo mailInfo) {
        String code = mailInfo.getTemplateCode();
        MailGenerator mailGenerator = map.get(code);
        if (mailGenerator == null) {
            throw new UnsupportedOperationException(code + " not supported yet");
        }

        String html = mailGenerator.generate(mailInfo);
        sendMail(html);
    }

    private void sendMail(String html) {
        System.out.println("was sent = " + html);
    }
}
