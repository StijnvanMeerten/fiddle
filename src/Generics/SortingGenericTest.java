package Generics;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SortingGenericTest <T extends Comparable> {
    private SortingGeneric sorting = new SortingGeneric();
    private Integer[] a = {7, 6, 2, 3, 6, 5, 10, 1, 8, 2 ,4};
    private Integer[] sortedA = {1, 2, 2, 3, 4, 5, 6, 6, 7, 8, 10};
    private Integer[] b = {};
    private Integer[] sortedB = {};
    private Integer[] c = {10, 8, 7, 6, 6, 5, 4, 3, 2, 2, 1};
    private Integer[] sortedC= {1, 2, 2, 3, 4, 5, 6, 6, 7, 8, 10};
    private MemoryCell mA = new MemoryCell();
    private MemoryCell mB = new MemoryCell();
    private MemoryCell mC = new MemoryCell();
    private MemoryCell[] memoryCellsInts = {mA, mB, mC};
    private MemoryCell[] memoryCellsIntsSorted = {mB, mA, mC};
    private MemoryCell mD = new MemoryCell();
    private MemoryCell mE = new MemoryCell();
    private MemoryCell mF = new MemoryCell();
    private MemoryCell[] memoryCellsStrings = {mD, mE, mF};
    private MemoryCell[] memoryCellsStringsSorted = {mF, mD, mE};

    @Before
    public void pre() {
        mA.write(8);
        mB.write(3);
        mC.write(713);
        mD.write("Objecten");
        mE.write("Voorwerpen");
        mF.write("Dingen");
    }

    @Test
    public void runInsertionNormal(){
        runInsertionSort(a, sortedA);
    }
    @Test
    public void runInsertionEmpty(){
        runInsertionSort(b, sortedB);
    }
    @Test
    public void runInsertionReverse(){
        runInsertionSort(c, sortedC);
    }
    @Test
    public void runMergeNormal(){
        runMergeSort(a, sortedA);
    }
    @Test
    public void runMergeEmpty(){
        runMergeSort(b, sortedB);
    }
    @Test
    public void runMergeReverse(){
        runMergeSort(c, sortedC);
    }

    @Test
    public void runQuickSortNormal(){
        runQuickSort(a, sortedA);
    }
    @Test
    public void runQuickSortEmpty(){
        runQuickSort(b, sortedB);
    }
    @Test
    public void runQuickSortReverse(){
        runQuickSort(c, sortedC);
    }

    @Test
    public void runInsertionSortCellsInts(){
        runInsertionSort(memoryCellsInts, memoryCellsIntsSorted);
    }
    @Test
    public void runMergeSortCellsInts(){
        runMergeSort(memoryCellsInts, memoryCellsIntsSorted);
    }
    @Test
    public void runQuickSortCellsInts(){
        runQuickSort(memoryCellsInts, memoryCellsIntsSorted);
    }

    @Test
    public void runInsertionSortCellsStrings(){
        runInsertionSort(memoryCellsStrings, memoryCellsStringsSorted);
    }
    @Test
    public void runMergeSortCellsStrings(){
        runMergeSort(memoryCellsStrings, memoryCellsStringsSorted);
    }
    @Test
    public void runQuickSortCellsStrings(){
        runQuickSort(memoryCellsStrings, memoryCellsStringsSorted);
    }


    private <T extends Comparable> void runInsertionSort(T[] unsorted, T[] sorted) {
        assertArrayEquals(sorted, sorting.insertionSort(unsorted));
    }

    private <T extends Comparable> void runMergeSort(T[] unsorted, T[] sorted) {
        assertArrayEquals(sorted, sorting.mergeSort(unsorted));
    }

    private <T extends Comparable> void runQuickSort(T[] unsorted, T[] sorted) {
        assertArrayEquals(sorted, sorting.quickSort(unsorted));
    }
}
