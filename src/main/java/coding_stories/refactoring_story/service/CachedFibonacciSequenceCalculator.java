package coding_stories.refactoring_story.service;

import coding_stories.refactoring_story.service.cached.CashedCalculationServiceTemplate;

public class CachedFibonacciSequenceCalculator extends CashedCalculationServiceTemplate {

    public CachedFibonacciSequenceCalculator(int capacity) {
        super(capacity);
    }

    @Override
    protected String performCalculations(int orderInSequence) {
        if (orderInSequence == 0) {
            return "0";
        }

        if (orderInSequence == 1){
            return "1";
        }

        return "" + calculateFibonacci(orderInSequence);
    }

    private int calculateFibonacci(int orderInSequence) {
        int first = 0;
        int second = 1;
        int nth = 1;

        for (int i = 2; i <= orderInSequence; i++) {
            nth = first + second;
            first = second;
            second = nth;
        }

        return nth;
    }

    @Override
    public String getCacheName() {
        return "fibonacci cache";
    }
}
