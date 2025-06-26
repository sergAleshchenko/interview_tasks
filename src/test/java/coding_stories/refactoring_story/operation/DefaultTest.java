package coding_stories.refactoring_story.operation;

import coding_stories.refactoring_story.operation.impl.Default;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DefaultTest {

    @Test
    public void actDefaultTest() {
        assertEquals("text33", new Default("text").act(33));
    }
}
