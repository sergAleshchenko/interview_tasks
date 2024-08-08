package tdd;

import akvelon.BalancedBrackets;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sergei Aleshchenko
 */
public class BalancedBracketsTest {


    @Test
    public void isEmptyStringBalanced() {
        BalancedBrackets bb = new BalancedBrackets();
        Assert.assertEquals(true, bb.isBalanced(""));
    }

    @Test
    public void isNullBalanced() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(false, bb.isBalanced(null));
    }

    @Test
    public void twoBracketsBalanced() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(true, bb.isBalanced("()"));
    }

    @Test
    public void twoBracketsBalanced2() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(true, bb.isBalanced("[]"));
    }

    @Test
    public void twoBracketsBalanced3() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(true, bb.isBalanced("{}"));
    }

    @Test
    public void sixBracketsBalanced() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(true, bb.isBalanced("()[]{}"));
    }

    @Test
    public void allOpenBrackets() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(false, bb.isBalanced("(((("));
    }


    @Test
    public void allClosedBrackets1() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(false, bb.isBalanced("]]]]]"));
    }


    @Test
    public void allOpenBrackets2() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(false, bb.isBalanced("{{{{"));
    }

    @Test
    public void allClosedBrackets2() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(false, bb.isBalanced("}}}}}"));
    }


    @Test
    public void allOpenBrackets1() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(false, bb.isBalanced("[[[[["));
    }


    @Test
    public void allClosedBrackets() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(false, bb.isBalanced("))))"));
    }

    @Test
    public void testCase1() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(false, bb.isBalanced("([)]"));
    }

    @Test
    public void testCase2() {
        BalancedBrackets bb = new BalancedBrackets();

        //   ()[]{}

        Assert.assertEquals(true, bb.isBalanced("(1+6)"));
    }

    @Test
    public void testCase3() {
        BalancedBrackets bb = new BalancedBrackets();

        //   ()[]{}

        Assert.assertEquals(false, bb.isBalanced(")("));
    }
}
