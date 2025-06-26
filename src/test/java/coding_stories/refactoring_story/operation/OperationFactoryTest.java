package coding_stories.refactoring_story.operation;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class OperationFactoryTest {
    @Test
    void createExactOperationThenMatchTest() {
        Operation defaultOperation = Mockito.mock(Operation.class);
        Operation operation1 = Mockito.mock(Operation.class);
        Operation operation2 = Mockito.mock(Operation.class);
        when(operation1.getOperationName()).thenReturn("some");
        when(operation2.getOperationName()).thenReturn("other");

        Operation result = new OperationFactory(List.of(operation1, operation2), defaultOperation)
                .createOperation("some");
        assertEquals(operation1, result);
    }

    @Test
    void createDefaultOperationThenNotMatchTest() {
        Operation defaultOperation = Mockito.mock(Operation.class);
        Operation operation1 = Mockito.mock(Operation.class);
        Operation operation2 = Mockito.mock(Operation.class);
        when(operation1.getOperationName()).thenReturn("something");
        when(operation2.getOperationName()).thenReturn("other");

        Operation result = new OperationFactory(List.of(operation1, operation2), defaultOperation)
                .createOperation("some");
        assertEquals(defaultOperation, result);
    }

    @Test
    void createDefaultOperationThenNothingElseTest() {
        Operation defaultOperation = Mockito.mock(Operation.class);
        Operation result = new OperationFactory(new ArrayList<>(), defaultOperation).createOperation("some");
        assertEquals(defaultOperation, result);
    }
}
