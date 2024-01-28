package evgeny_borisov.spring_data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Sergei Aleshchenko
 */
@Service
public class SpeakerServiceImpl implements SpeakerService {

    @Autowired
    private SpeakerRepository speakerRepository;

    @Override
    public Speaker saveSpeaker(Speaker speaker) {
        return speakerRepository.save(speaker);
    }

    @Override
    public List<Speaker> fetchSpeakerList() {
        return (List<Speaker>) speakerRepository.findAll();
    }

    @Override
    public Optional<Speaker> fetchSpeakerById(Long id) {
        return speakerRepository.findById(id);
    }

    @Override
    public void deleteSpeakerById(Long speakerId) {
        speakerRepository.deleteById(speakerId);
    }
}
