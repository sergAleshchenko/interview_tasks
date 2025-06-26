package coding_stories.refactoring_story.operation.impl;

import coding_stories.refactoring_story.dto.CacheItem;
import coding_stories.refactoring_story.operation.Operation;
import coding_stories.refactoring_story.service.cached.CashedCalculationService;

import java.util.List;
import java.util.Map;

public class GetCaches implements Operation {
    private final List<CashedCalculationService> services;

    public GetCaches(List<CashedCalculationService> services) {
        this.services = services;
    }

    @Override
    public String act(int number) {
        StringBuilder result = new StringBuilder();
        for (CashedCalculationService service: services) {
            result.append(service.getCacheName()).append(": {");
            for (Map.Entry<Integer, CacheItem> e: service.getCache().entrySet()) {
                result.append(e.getKey()).append(" : ").append(e.getValue().getValue()).append("; ");
            }
            result.append("} ");
        }
        return result.toString();
    }

    @Override
    public String getOperationName() {
        return "get caches";
    }
}
