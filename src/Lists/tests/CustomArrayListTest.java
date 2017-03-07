package Lists.tests;

import Lists.CustomArrayList;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.Arrays;

public class CustomArrayListTest {

    private CustomArrayList customArrayList;
    private int numbersInList = 10;

    @Before
    public void pre() {
        customArrayList = new CustomArrayList();
        addXints(customArrayList, numbersInList);
    }

    @Test
    public void getEveryIntInList() {
        for(int i=0; i<numbersInList; i++) {
            Assert.assertEquals(i, customArrayList.get(i));
        }
    }

    @Test
    public void setEveryValueTo10() {
        for(int i=0; i<numbersInList; i++) {
            customArrayList.set(i, 10);
            Assert.assertEquals(10, customArrayList.get(i));
        }
    }

    @Test
    public void testToString(){
        Assert.assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", customArrayList.toString());
    }

    private void addXints(CustomArrayList customArrayList, int amountToAdd) {
        for(int i=0; i<amountToAdd; i++){
            customArrayList.add(i);
        }
    }
}
