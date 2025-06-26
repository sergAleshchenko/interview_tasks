package coding_stories.refactoring_story.service;

import coding_stories.refactoring_story.dto.CacheItem;
import coding_stories.refactoring_story.operation.Operation;
import coding_stories.refactoring_story.operation.OperationFactory;
import coding_stories.refactoring_story.operation.impl.*;
import coding_stories.refactoring_story.service.cached.CashedCalculationService;
import coding_stories.refactoring_story.service.cached.CashedCalculationServiceTemplate;
import org.hibernate.annotations.Check;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MathService {
    private final CachedPrimeNumberChecker primeNumberChecker;
    private final CachedFibonacciSequenceCalculator fibonacciSequenceCalculator;

    public MathService(int fibonacciCacheSize, int primeCacheSize) {
        this.primeNumberChecker = new CachedPrimeNumberChecker(fibonacciCacheSize);
        this.fibonacciSequenceCalculator = new CachedFibonacciSequenceCalculator(primeCacheSize);

    }

    public String calculate(int number, String operation) throws Exception {
        String record = getOperationFactory(operation)
                .createOperation(operation)
                .act(number);

        externalServiceCall(record);

        return record;
    }

    private OperationFactory getOperationFactory(String operation) {
        List<Operation> supportedOps = new ArrayList<>();
        List<CashedCalculationService> allServices =
                List.of(fibonacciSequenceCalculator, primeNumberChecker);

        supportedOps.add(new CalculateFibonacci(fibonacciSequenceCalculator));
        supportedOps.add(new CheckPrime(primeNumberChecker));
        supportedOps.add(new CleanCaches(allServices));
        supportedOps.add(new GetCaches(allServices));

        return new OperationFactory(supportedOps, new Default(operation));
    }

    protected void externalServiceCall(String record) throws Exception {
        URL url = new URL("https://record-logger.com/post/json");
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        http.setRequestMethod("POST");
        http.setDoOutput(true);
        http.setRequestProperty("Content-Type", "application/json");
        String data = "{\"record\": \" " + record + "\"}";
        byte[] out = data.getBytes(StandardCharsets.UTF_8);
        OutputStream stream = http.getOutputStream();
        stream.write(out);
        http.disconnect();
    }
}
