package Sorting;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SortingTest {
    private Sorting sorting = new Sorting();
    private int[] a = {7, 6, 2, 3, 6, 5, 10, 1, 8, 2 ,4};
    private int[] sortedA = {1, 2, 2, 3, 4, 5, 6, 6, 7, 8, 10};
    private int[] b = {};
    private int[] sortedB = {};
    private int[] c = {10, 8, 7, 6, 6, 5, 4, 3, 2, 2, 1};
    private int[] sortedC= {1, 2, 2, 3, 4, 5, 6, 6, 7, 8, 10};

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

    private void runInsertionSort(int[] unsorted, int[] sorted) {
        assertArrayEquals(sorted, sorting.insertionSort(unsorted));
    }

    private void runMergeSort(int[] unsorted, int[] sorted) {
        assertArrayEquals(sorted, sorting.mergeSort(unsorted));
    }

    private void runQuickSort(int[] unsorted, int[] sorted) {
        assertArrayEquals(sorted, sorting.quickSort(unsorted));
    }
}
