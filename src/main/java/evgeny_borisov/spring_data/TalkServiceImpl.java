package evgeny_borisov.spring_data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Sergei Aleshchenko
 */
@Service
public class TalkServiceImpl implements TalkService {

    @Autowired
    private TalkRepository talkRepository;

    @Override
    public Talk saveTalk(Talk talk) {
        return talkRepository.save(talk);
    }

    @Override
    public List<Talk> fetchTalkList() {
        return (List<Talk>) talkRepository.findAll();
    }

    @Override
    public Optional<Talk> fetchTalkById(Long id) {
        return talkRepository.findById(id);
    }

    @Override
    public Optional<Talk> fetchTalkByTitle(String title) {
        return talkRepository.findByTitle(title);
    }

    @Override
    public void deleteTalkById(Long talkId) {
        talkRepository.deleteById(talkId);
    }

    @Override
    public List<Talk> fetchTalkByTitleLike(String titleLike) {
        return talkRepository.findByTitleLike(titleLike);
    }

    @Override
    public List<Talk> fetchTalkByTitleEndingWith(String suffix) {
        return talkRepository.findByTitleEndingWith(suffix);
    }
}
