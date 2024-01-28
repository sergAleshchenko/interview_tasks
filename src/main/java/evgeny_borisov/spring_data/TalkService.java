package evgeny_borisov.spring_data;

import java.util.List;
import java.util.Optional;

/**
 * @author Sergei Aleshchenko
 */
public interface TalkService {
    Talk saveTalk(Talk Talk);

    List<Talk> fetchTalkList();
    Optional<Talk> fetchTalkById(Long id);
    Optional<Talk> fetchTalkByTitle(String title);

    void deleteTalkById(Long talkId);

    List<Talk> fetchTalkByTitleLike(String titleLike);
    List<Talk> fetchTalkByTitleEndingWith(String suffix);
}
