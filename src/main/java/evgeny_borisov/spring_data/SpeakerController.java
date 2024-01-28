package evgeny_borisov.spring_data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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
