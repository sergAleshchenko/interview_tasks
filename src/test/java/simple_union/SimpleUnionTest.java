package simple_union;

import interview_300_questions.simple_union.SimpleUnion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sergei Aleshchenko
 */
public class SimpleUnionTest {

    private String[] urls;

    @Before
    public void initUnions() {
        urls = new String[]{
                "www.google.com/asasdfasdfasdfasdf/",
                "http://www.yahoo.com/asasdfasdfasdfasdf"
        };
    }

    @Test
    public void shortUnion() {
        SimpleUnion simpleUnion = new SimpleUnion();
        String shortUtion1 = simpleUnion.shortenURL(urls[0]);
        String shortUtion2 = simpleUnion.shortenURL(urls[1]);

        Assert.assertTrue(shortUtion1.length() <= 30);
        Assert.assertTrue(shortUtion2.length() <= 30);
    }
}
