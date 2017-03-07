package Lists.tests;

import Lists.HANStack;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class HANStackTest {
    private HANStack hanStack;
    private int numbersInStack = 5;

    @Before
    public void pre() {
        hanStack = new HANStack();
        addXIntegers(hanStack, numbersInStack);
    }

    @Test
    public void properlyPushed() {
        Assert.assertEquals(numbersInStack, hanStack.getSize());
    }

    @Test
    public void popLast() {
        Assert.assertEquals(numbersInStack, hanStack.getSize());
        hanStack.pop();
        Assert.assertEquals(numbersInStack-1, hanStack.getSize());
    }

    @Test
    public void topIsMostRecentNumber() {
        Assert.assertEquals(numbersInStack-1, hanStack.top());
    }

    @Test
    public void toStringTest(){
        Assert.assertEquals("43210", hanStack.toString());
    }

    private void addXIntegers(HANStack hanStack, int amountToAdd) {
        for(int i=0; i<amountToAdd; i++){
           hanStack.push(i);
        }
    }
}
