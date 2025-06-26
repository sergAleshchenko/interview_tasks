package coding_stories.refactoring_story.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CacheItem {
    private String value;
    private int frequency;
    private final long availableFrom;

    public CacheItem() {
        availableFrom = new Date().getTime();
    }
}
