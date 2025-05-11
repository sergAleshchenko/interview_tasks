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
    public void sixBracketsBalanced1() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(true, bb.isBalanced("{}()"));
    }

    @Test
    public void sixBracketsBalanced2() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(true, bb.isBalanced("({()})"));
    }

    @Test
    public void sixBracketsBalanced3() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(true, bb.isBalanced("[]"));
    }

    @Test
    public void sixBracketsBalanced4() {
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

        Assert.assertEquals(true, bb.isBalanced("()"));
    }

    @Test
    public void testCase3() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(false, bb.isBalanced(")("));
    }

    @Test
    public void testCase4() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(false, bb.isBalanced("{}("));
    }


    @Test
    public void testCase5() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(true, bb.isBalanced("({}[])"));
    }

    @Test
    public void testCase6() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(false, bb.isBalanced("(({()})))"));
    }

    @Test
    public void testCase7() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(true, bb.isBalanced("({(){}()})()({(){}()})(){()}"));
    }

    @Test
    public void testCase8() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(false, bb.isBalanced("{}()))(()()({}}{}"));
    }

    @Test
    public void testCase9() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(false, bb.isBalanced("}}}}"));
    }

    @Test
    public void testCase10() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(false, bb.isBalanced("))))"));
    }


    @Test
    public void testCase11() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(false, bb.isBalanced("{{{"));
    }

    @Test
    public void testCase12() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(false, bb.isBalanced("((("));
    }


    @Test
    public void testCase13() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(true, bb.isBalanced("[]{}(){()}((())){{{}}}{()()}{{}{}}"));
    }

    @Test
    public void testCase14() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(true, bb.isBalanced("[[]][][]"));
    }

    @Test
    public void testCase15() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(false, bb.isBalanced("}{"));
    }


    @Test
    public void testCaseNew1() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(true, bb.isBalanced("[({})(())]"));
    }

    @Test
    public void testCaseNew2() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(false, bb.isBalanced("(({()})))[["));
    }

    @Test
    public void testCaseNew3() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(true, bb.isBalanced("({(){}()})()({(){}()})(){()}{}((()))"));
    }

    @Test
    public void testCaseNew4() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(false, bb.isBalanced("{}()))(()()({}}{}"));
    }

    @Test
    public void testCaseNew5() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(false, bb.isBalanced("}}}}"));
    }

    @Test
    public void testCaseNew6() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(false, bb.isBalanced("))))"));
    }

    @Test
    public void testCaseNew7() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(false, bb.isBalanced("{{{"));
    }

    @Test
    public void testCaseNew8() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(false, bb.isBalanced("((("));
    }

    @Test
    public void testCaseNew9() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(true, bb.isBalanced("{}(){()}((())){{{}}}{()()}{{}{}}"));
    }

    @Test
    public void testCaseNew10() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(false, bb.isBalanced("{{{{{{{)))))))))))))))))))"));
    }

    @Test
    public void testCaseNew11() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(false, bb.isBalanced("{}{}("));
    }

    @Test
    public void testCaseNew12() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(false, bb.isBalanced("{}}}{}"));
    }

    @Test
    public void testCaseNew13() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(false, bb.isBalanced("()()()())))"));
    }

    @Test
    public void testCaseNew14() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(false, bb.isBalanced("(((((()()()"));
    }

    @Test
    public void testCaseNew15() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(true, bb.isBalanced("(){}{{}}()(()){{()()}}"));
    }

    @Test
    public void testCaseNew16() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(true, bb.isBalanced("{}{{{}}}{{{((()))}}}"));
    }

    @Test
    public void testCaseNew17() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(true, bb.isBalanced("((()))[]"));
    }

    @Test
    public void testCaseNew18() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(true, bb.isBalanced("{{}}(()[])"));
    }


    @Test
    public void testCaseNewNew1() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(true, bb.isBalanced("{}()"));
    }

    @Test
    public void testCaseNewNew2() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(true, bb.isBalanced("({()})"));
    }


    @Test
    public void testCaseNewNew3() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(false, bb.isBalanced("{}("));
    }


    @Test
    public void testCaseNewNew4() {
        BalancedBrackets bb = new BalancedBrackets();

        Assert.assertEquals(true, bb.isBalanced("[]"));
    }


}
