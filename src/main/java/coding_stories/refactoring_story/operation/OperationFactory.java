package coding_stories.refactoring_story.operation;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OperationFactory {
    public final Map<String, Operation> operationMap;
    public final Operation defaultOperation;

    public OperationFactory(List<Operation> supportedOperations, Operation defaultOperation) {
        this.operationMap = supportedOperations.stream()
                .collect(Collectors.toMap(Operation::getOperationName, Function.identity()));
        this.defaultOperation = defaultOperation;
    }

    public Operation createOperation(String operation) {
        return operationMap.getOrDefault(operation, defaultOperation);
    }
}
