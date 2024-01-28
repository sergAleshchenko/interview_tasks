package evgeny_borisov.spring_data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Sergei Aleshchenko
 */
@RestController
public class SpeakerController {

    @Autowired
    private SpeakerService speakerService;

    @PostMapping("/speakers")
    public Speaker saveSpeaker(@RequestBody Speaker speaker) {
        return speakerService.saveSpeaker(speaker);
    }

    @GetMapping("/speakers/{id}")
    public Optional<Speaker> fetchSpeakerById(@PathVariable("id") Long speakerId) {
        return speakerService.fetchSpeakerById(speakerId);
    }

    @GetMapping("/speakers/get/{name}")
    public Optional<Speaker> fetchSpeakerByName(@PathVariable("name") String name) {
        return speakerService.fetchSpeakerByName(name);
    }

    @GetMapping("/speakers/like/{nameLike}")
    public List<Speaker> fetchSpeakerByNameLike(@PathVariable("nameLike") String nameLike) {
        return speakerService.fetchSpeakerByNameLike("%" + nameLike + "%");
    }

    @GetMapping("/speakers/title/like/{titleLike}")
    public List<Speaker> fetchSpeakerWithSpecificTalks(@PathVariable("titleLike") String titleLike) {
        return speakerService.fetchSpeakersWithSpecificTalks(titleLike);
    }


    @GetMapping("/speakers/suf/{suffix}")
    public List<Speaker> fetchSpeakerByNameEndingWith(@PathVariable("suffix") String suffix) {
        return speakerService.fetchSpeakerByNameEndingWith(suffix);
    }


    @GetMapping("/speakers")
    public List<Speaker> fetchSpeakerList() {
        return speakerService.fetchSpeakerList();
    }


    @DeleteMapping("/speakers/{id}")
    public String deleteSpeakerById(@PathVariable("id") Long speakerId) {
        speakerService.deleteSpeakerById(speakerId);
        return "Deleted Successfully";
    }
}
