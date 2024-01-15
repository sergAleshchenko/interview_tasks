package lambdas.examManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergei Aleshchenko
 */
public class ExamManager {
    public interface CalculationFunctionInterface {
        Double execute(List<Double> scores);
    }

    private List<Double> myScores;

    public ExamManager() {
        myScores = new ArrayList<>();
        myScores.add(78.3);
        myScores.add(69.2);
        myScores.add(44.7);
        myScores.add(61.6);
        myScores.add(80.2);
        myScores.add(66.9);
        myScores.add(54.1);
    }

    public Double customCalculation(CalculationFunctionInterface calculator) {
        return calculator.execute(myScores);
    }
}
