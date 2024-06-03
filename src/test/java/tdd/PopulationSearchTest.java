package tdd;

import interview_300_questions.PopulationSearch;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sergei Aleshchenko
 */
public class PopulationSearchTest {

    @Test
    public void findPopulation() {
        String city = "Bangalore";
        int expected = 200000;

        PopulationSearch ps = new PopulationSearch();
        int count = ps.getPopulation(city);
        Assert.assertEquals(expected, count);
    }

    @Test(expected = NullPointerException.class)
    public void findPopulationWithEmptyInput() {
        String city = "";
        int expected = 0;

        PopulationSearch ps = new PopulationSearch();
        int count = ps.getPopulation(city);
        Assert.assertEquals(expected, count);
    }

    @Test(expected = NullPointerException.class)
    public void findPopulationWithInvalidInput() {
        String city = "XYZ";
        int expected = 0;

        PopulationSearch ps = new PopulationSearch();
        int count = ps.getPopulation(city);
        Assert.assertEquals(expected, count);
    }
}
