package coding_stories.refactoring_story.operation.impl;

import coding_stories.refactoring_story.operation.Operation;
import coding_stories.refactoring_story.service.cached.CashedCalculationService;

import java.util.List;

public class CleanCaches implements Operation {
    private final List<CashedCalculationService> services;

    public CleanCaches(List<CashedCalculationService> services) {
        this.services = services;
    }

    @Override
    public String act(int number) {
        for (CashedCalculationService service : services) {
            service.cleanCache();
        }
        return "done";
    }

    @Override
    public String getOperationName() {
        return "clean caches";
    }
}
