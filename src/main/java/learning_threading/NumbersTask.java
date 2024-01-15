package learning_threading;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * @author Sergei Aleshchenko
 */
public class NumbersTask implements Callable<Double> {

    private Double longRunningMethod() throws InterruptedException {
        Double j = 1.01;
        for (long l = 1; l < 1000000L; l++) {
            j += 1.01;
            System.out.println("Task number " + Thread.currentThread().getName() +
                    " is outputting number " + j);

            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
        }
        return  j;
    }

    @Override
    public Double call() {
        System.out.println("Task number " +
                Thread.currentThread().getName() + " is starting");

        Double result = 0d;

        try {
            result = longRunningMethod();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return result;
    }
}
