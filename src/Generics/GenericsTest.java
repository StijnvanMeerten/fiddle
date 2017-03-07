package Generics;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GenericsTest {
    private int[] intArray = {7, 6, 2, 3, 6, 5, 10, 1, 8, 2 ,4};
    private String[] strings = {"Banaan", "appel", "kiwi", "Abrikoos"};
    private Square square = new Square(10);

    @Test
    public void checkIfCompareToWorksProperly(){
        Square b = new Square(5);
        Assert.assertEquals(b.compareTo(square), -1);
        b = new Square(10);
        Assert.assertEquals(b.compareTo(square), 0);
        b = new Square(15);
        Assert.assertEquals(b.compareTo(square), 1);
    }

    @Test
    public void checkIfGetSmallestReturnsSmallestInt()
    {
        assertEquals(Generics.getSmallest(strings), strings[3]);
    }
}
