package coding_stories.refactoring_story.operation;

import coding_stories.refactoring_story.operation.impl.CleanCaches;
import coding_stories.refactoring_story.service.cached.CashedCalculationService;
import org.junit.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CleanCachesTest {

    @Test
    public void cleanCachesTest() {
        CashedCalculationService service1 = mock(CashedCalculationService.class);
        CashedCalculationService service2 = mock(CashedCalculationService.class);

        String result = new CleanCaches(List.of(service1, service2)).act(0);

        verify(service1).cleanCache();
        verify(service2).cleanCache();

        assertEquals("done", result);
    }
}
