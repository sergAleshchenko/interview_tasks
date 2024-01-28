package evgeny_borisov.spring_data;

import java.util.List;
import java.util.Optional;

/**
 * @author Sergei Aleshchenko
 */
public interface SpeakerService {

    Speaker saveSpeaker(Speaker speaker);

    List<Speaker> fetchSpeakerList();
    Optional<Speaker> fetchSpeakerById(Long id);
    Optional<Speaker> fetchSpeakerByName(String name);

    void deleteSpeakerById(Long speakerId);

    List<Speaker> fetchSpeakerByNameLike(String nameLike);
    List<Speaker> fetchSpeakerByNameEndingWith(String suffix);

    List<Speaker> fetchSpeakersWithSpecificTalks(String titleLike);
}
