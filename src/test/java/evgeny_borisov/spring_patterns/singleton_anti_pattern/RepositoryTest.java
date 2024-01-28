package evgeny_borisov.spring_patterns.singleton_anti_pattern;

import evgeny_borisov.spring_data.Speaker;
import evgeny_borisov.spring_data.SpeakerRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Sergei Aleshchenko
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestConfiguration.class})
public class RepositoryTest {

    @Autowired
    private SpeakerRepository speakerRepository;

    private static Log log = LogFactory.getLog(RepositoryTest.class);


    @Test
    public void testSpeakersWithSpringTalks() {
        List<Speaker> speakers = speakerRepository.findByTalksTitleLikeIgnoreCase("%spring%");
        speakers.forEach(s -> log.info(s.toString()));
    }

    @Test
    public void testFindByTalksWhenBetween() {
        List<Speaker> speakers = speakerRepository.findByTalksWhenBetween(
                Date.valueOf(LocalDate.parse("2022-03-01")),
                Date.valueOf(LocalDate.parse("2022-03-10")));

        speakers.forEach(s -> log.info(s.toString()));
    }
}
