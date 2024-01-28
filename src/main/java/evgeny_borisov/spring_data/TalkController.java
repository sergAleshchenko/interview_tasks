package evgeny_borisov.spring_data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Sergei Aleshchenko
 */
@RestController
public class TalkController {
    @Autowired
    private TalkService talkService;

    @GetMapping("/talks")
    public List<Talk> fetchTalkList() {
        return talkService.fetchTalkList();
    }
}
