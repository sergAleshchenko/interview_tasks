package evgeny_borisov.spring_patterns.never_use_switch;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author Sergei Aleshchenko
 */
@Service
@AllArgsConstructor
public class MailProducer {
    private final MailSender mailSender;
//    private final Faker faker;

    @Scheduled(fixedDelay = 1000)
    public void generateMail() {
//        MailInfo mailInfo = MailInfo.builder()
//                .content(faker.chuckNorris().fact())
//                .templateCode(String.valueOf(faker.random().nextInt(3) + 1));
//        mailSender.send(mailInfo);
    }
}
