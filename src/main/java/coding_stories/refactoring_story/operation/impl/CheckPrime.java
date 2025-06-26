package coding_stories.refactoring_story.operation.impl;

import coding_stories.refactoring_story.operation.Operation;
import coding_stories.refactoring_story.service.cached.CashedCalculationService;

public class CheckPrime implements Operation {
    private final CashedCalculationService service;

    public CheckPrime(CashedCalculationService service) {
        this.service = service;
    }

    @Override
    public String act(int number) {
        return service.calculate(number);
    }

    @Override
    public String getOperationName() {
        return "check prime";
    }
}
