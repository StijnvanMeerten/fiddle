package Sorting;

import java.util.Arrays;

public class Sorting {
    int[] helper;

    public int[] insertionSort(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            for (int j = i; j > 0; j++) {
                if (checkIfNumberIsLowerThanThePrevious(numbers, j)) {
                    numbers = swapNumbers(numbers, j);
                    j = j - 2;
                } else {
                    break;
                }
            }
        }
        return numbers;
    }

    private int[] swapNumbers(int[] numbers, int i) {
        int temp = numbers[i - 1];
        numbers[i - 1] = numbers[i];
        numbers[i] = temp;
        System.out.println(Arrays.toString(numbers));
        return numbers;
    }

    private boolean checkIfNumberIsLowerThanThePrevious(int[] numbers, int i) {
        return numbers[i] < numbers[i - 1];
    }

    public int[] mergeSort(int[] values) {
        helper = new int[values.length];
        return mergesort(values, 0, values.length - 1);
    }

    private int[] mergesort(int[] values, int low, int high) {
        // check if low is smaller then high, if not then the array is sorted
        if (low < high) {
            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            // Sort the left side of the array
            mergesort(values, low, middle);
            // Sort the right side of the array
            mergesort(values, middle + 1, high);
            // Combine them both
            return merge(values, low, middle, high);
        }
        return values;
    }

    private int[] merge(int[] values, int low, int middle, int high) {

        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            System.out.println(helper[i] + " " + values[i]);
            helper[i] = values[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                values[k] = helper[i];
                i++;
            } else {
                values[k] = helper[j];
                j++;
            }
            k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            values[k] = helper[i];
            k++;
            i++;
        }
        return values;
    }

    public int[] quickSort(int[] numbers) {
        if (numbers.length < 2) {
            return numbers;
        }
        int a = numbers[0];
        int b = numbers[numbers.length - 1];
        int c = numbers[numbers.length / 2];

        if ((a >= b && a <= c) || (a <= b && a >= c)) {
            return split(numbers, a);
        } else if ((b >= a && b <= c) || (b >= a && b <= c)) {
            return split(numbers, b);
        } else {
            return split(numbers, c);
        }
    }

    private int[] split(int[] numbers, int pivot) {
        int[] num2;
        num2 = splitArray(numbers, pivot, true);
        numbers = splitArray(numbers, pivot, false);
        num2 = quickSort(num2);
        numbers = quickSort(numbers);

        int[] newArray = new int[numbers.length + num2.length + 1];
        System.arraycopy(numbers, 0, newArray, 0, numbers.length);
        newArray[numbers.length] = pivot;
        System.arraycopy(num2, 0, newArray, numbers.length + 1, num2.length);
        System.out.println(Arrays.toString(newArray));
        return newArray;
    }

    private int[] splitArray(int[] numbers, int pivot, boolean takeHigherThanPivot) {
        int[] newArray = new int[0];
        boolean pastPivot = false;
        for (int number : numbers) {
            if (number == pivot && takeHigherThanPivot) {
                if (!pastPivot) {
                    pastPivot = true;
                } else {
                    newArray = Arrays.copyOf(newArray, newArray.length + 1);
                    newArray[newArray.length - 1] = number;
                }
            } else if (number > pivot && takeHigherThanPivot) {
                newArray = Arrays.copyOf(newArray, newArray.length + 1);
                newArray[newArray.length - 1] = number;
            } else if (number < pivot && !takeHigherThanPivot) {
                newArray = Arrays.copyOf(newArray, newArray.length + 1);
                newArray[newArray.length - 1] = number;
            }
        }
        return newArray;
    }
}
