package coding_stories.refactoring_story.service;

import coding_stories.refactoring_story.service.cached.CashedCalculationServiceTemplate;

public class CachedPrimeNumberChecker extends CashedCalculationServiceTemplate {

    public CachedPrimeNumberChecker(int capacity) {
        super(capacity);
    }

    @Override
    protected String performCalculations(int numberToCheck) {
        if (numberToCheck < 1) {
            return "number is not positive";
        }

        return checkIsPrime(numberToCheck) ? "number is prime" : "number is not prime";
    }

    private boolean checkIsPrime(int numberToCheck) {
        if (numberToCheck == 1) {
            return true;
        }

        for (int i = 2; i < numberToCheck; i++) {
            if (numberToCheck % i == 0) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String getCacheName() {
        return "prime cache";
    }
}
