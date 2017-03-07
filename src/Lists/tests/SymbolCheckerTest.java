package Lists.tests;

import Lists.SymbolChecker;
import org.junit.Assert;
import org.junit.Test;

public class SymbolCheckerTest {

    private String correctString = "(tes(t))";
    private String tooManyLeftBrackets = "(tes((t))";
    private String toomanyRightBrackets = "(tes(t)))";

    @Test
    public void normalStringWorks() {
        Assert.assertTrue(SymbolChecker.checkBrackets(correctString));
    }

    @Test
    public void leftStringFalse() {
        Assert.assertFalse(SymbolChecker.checkBrackets(tooManyLeftBrackets));
    }
    @Test
    public void rightStringFalse() {
        Assert.assertFalse(SymbolChecker.checkBrackets(toomanyRightBrackets));
    }
}