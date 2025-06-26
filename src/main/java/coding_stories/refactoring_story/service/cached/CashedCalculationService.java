package coding_stories.refactoring_story.service.cached;

import coding_stories.refactoring_story.dto.CacheItem;

import java.util.Map;

public interface CashedCalculationService {
    String calculate(int number);

    Map<Integer, CacheItem> getCache();

    void cleanCache();

    String getCacheName();
}
