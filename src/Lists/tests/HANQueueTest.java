package Lists.tests;

import Lists.HANQueue;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class HANQueueTest {
    private HANQueue hanQueue;
    private int numbersInQueue = 5;

    @Before
    public void pre() {
        hanQueue = new HANQueue();
        addXIntegers(hanQueue, numbersInQueue);
    }

    @Test
    public void properlyPushed() {
        Assert.assertEquals(numbersInQueue, hanQueue.getSize());
    }

    @Test
    public void popLast() {
        Assert.assertEquals(numbersInQueue, hanQueue.getSize());
        hanQueue.pop();
        Assert.assertEquals(numbersInQueue -1, hanQueue.getSize());
    }

    @Test
    public void checkIfFirstInFirstOut() {
        Assert.assertEquals(0, hanQueue.top());
        hanQueue.pop();
        Assert.assertEquals(1, hanQueue.top());
    }

    @Test
    public void toStringTest(){
        Assert.assertEquals("[0, 1, 2, 3, 4]", hanQueue.toString());
    }

    private void addXIntegers(HANQueue hanQueue, int amountToAdd) {
        for(int i=0; i<amountToAdd; i++){
            hanQueue.push(i);
        }
    }
}
