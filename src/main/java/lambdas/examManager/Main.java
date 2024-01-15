package lambdas.examManager;

/**
 * @author Sergei Aleshchenko
 */
public class Main {
    public static void main(String[] args) {
        ExamManager examManager = new ExamManager();

        ExamManager.CalculationFunctionInterface resultHighest =
                scores -> {
                    double highest = 0d;
                    for (Double nextScore : scores) {
                        highest = Math.max(highest, nextScore);
                    }
                    return highest;
                };

        ExamManager.CalculationFunctionInterface resultAverage =
                scores -> {
                    double sum = 0d;
                    for (Double nextScore : scores) {
                        sum += nextScore;
                    }
                    return sum / scores.size();
                };

        System.out.println(examManager.customCalculation(resultHighest));
        System.out.println(examManager.customCalculation(resultAverage));
    }
}
