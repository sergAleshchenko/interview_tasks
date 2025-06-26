package coding_stories.refactoring_story.operation.impl;

import coding_stories.refactoring_story.operation.Operation;
import coding_stories.refactoring_story.service.cached.CashedCalculationService;

public class CalculateFibonacci implements Operation {
    private final CashedCalculationService service;

    public CalculateFibonacci(CashedCalculationService service) {
        this.service = service;
    }

    @Override
    public String act(int number) {
        return service.calculate(number);
    }

    @Override
    public String getOperationName() {
        return "calculate fibonacci";
    }
}
