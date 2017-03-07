package Lists.tests;

import Lists.HANLinkedList;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class HANLinkedListTest {

    private HANLinkedList hanLinkedList;
    private int numbersInList = 10;

    @Before
    public void pre() {
        hanLinkedList = new HANLinkedList();
        addXIntegers(hanLinkedList, numbersInList);
    }

    @Test
    public void getEveryIntInList() {
        for(int i=0; i<numbersInList; i++) {
            Assert.assertEquals(i, hanLinkedList.get(i));
        }
    }

    @Test
    public void removeEverythingFromList() {
        for(int i=0; i<numbersInList; i++) {
            Assert.assertEquals(i, hanLinkedList.get(0));
            hanLinkedList.removeFirst();
        }
    }

    @Test
    public void addThreeValuesToFront(){
        for(int i=0; i<3; i++){
            hanLinkedList.addFirst(i+10);
            Assert.assertEquals(i+10, hanLinkedList.get(0));
        }
    }


    @Test
    public void deleteSecondToLastValueFromList(){
        Assert.assertEquals(numbersInList-2, hanLinkedList.get(numbersInList-2));
        hanLinkedList.delete(numbersInList-2);
        Assert.assertEquals(numbersInList-1, hanLinkedList.get(numbersInList-2));
    }

    @Test
    public void testToString(){
        Assert.assertEquals("0123456789", hanLinkedList.toString());
    }

    private void addXIntegers(HANLinkedList hanLinkedList, int amountToAdd) {
        for(int i=0; i<amountToAdd; i++){
            hanLinkedList.insert(i, i);
        }
    }
}
