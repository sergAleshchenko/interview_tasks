package interview_questions_300;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergei Aleshchenko
 */
public class PopulationSearch {
    public int getPopulation(String city) {
        Map<String, Integer> populationMap = null;
        int populationCount = 0;

        if (city.isEmpty()) {
            throw new NullPointerException("Input shouldn't be empty");
        }

        populationMap = getPopulationStatistic();

        if (!populationMap.containsKey(city)) {
            throw new NullPointerException("Invalid input");
        } else {
            populationCount = populationMap.get(city);
        }

        return populationCount;
    }

    // User can give empty input
    // Input may not be present in DB

    private Map<String, Integer> getPopulationStatistic() {
        Map<String, Integer> populationMap = new HashMap<>();
        populationMap.put("Bangalore", 200000);
        populationMap.put("Hyderabad", 500000);
        populationMap.put("Pune", 300000);
        populationMap.put("Mumbai", 800000);
        return populationMap;
    }
}
