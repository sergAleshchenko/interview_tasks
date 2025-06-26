package coding_stories.refactoring_story.service;

public class MathServiceTestDouble extends MathService {
    public MathServiceTestDouble(int fibonacciCacheSize, int primeCacheSize) {
        super(fibonacciCacheSize, primeCacheSize);
    }

    @Override
    protected void externalServiceCall(String record) throws Exception {
        //do nothing
    }
}
