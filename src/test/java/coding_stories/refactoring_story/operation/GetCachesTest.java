package coding_stories.refactoring_story.operation;

import coding_stories.refactoring_story.dto.CacheItem;
import coding_stories.refactoring_story.operation.impl.GetCaches;
import coding_stories.refactoring_story.service.cached.CashedCalculationService;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GetCachesTest {

    @Test
    public void getCachesTest() {

        CashedCalculationService service1 = mock(CashedCalculationService.class);
        when(service1.getCacheName()).thenReturn("fibonacci cache");
        CacheItem item11 = mock(CacheItem.class);
        when(item11.getValue()).thenReturn("3");
        CacheItem item12 = mock(CacheItem.class);
        when(item12.getValue()).thenReturn("1");
        when(service1.getCache()).thenReturn(Map.of(4, item11, 2, item12));

        CashedCalculationService service2 = mock(CashedCalculationService.class);
        when(service2.getCacheName()).thenReturn("prime cache");
        CacheItem item21 = mock(CacheItem.class);
        when(item21.getValue()).thenReturn("number is not prime");
        CacheItem item22 = mock(CacheItem.class);
        when(item22.getValue()).thenReturn("number is prime");
        when(service2.getCache()).thenReturn(Map.of(4, item21, 2, item22));

        String expected =
                "fibonacci cache: {4 : 3; 2 : 1; } " +
                        "prime cache: {4 : number is not prime; 2 : number is prime; } ";

        String result = new GetCaches(List.of(service1, service2)).act(0);

        assertEquals(expected, result);
    }


    @Test
    public void getCachesEmptyItemsTest() {
        CashedCalculationService service1 = mock(CashedCalculationService.class);
        when(service1.getCacheName()).thenReturn("fibonacci cache");

        CashedCalculationService service2 = mock(CashedCalculationService.class);
        when(service2.getCacheName()).thenReturn("prime cache");

        String expected = "fibonacci cache: {} prime cache: {} ";

        String result = new GetCaches(List.of(service1, service2)).act(0);

        assertEquals(expected, result);
    }
}
