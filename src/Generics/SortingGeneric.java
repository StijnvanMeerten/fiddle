package Generics;

import java.util.Arrays;

public class SortingGeneric<T extends Comparable> {
    T[] helper;

    public T[] insertionSort(T[] numbers) {
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

    private T[] swapNumbers(T[] numbers, int i) {
        T temp = numbers[i - 1];
        numbers[i - 1] = numbers[i];
        numbers[i] = temp;
        return numbers;
    }

    private boolean checkIfNumberIsLowerThanThePrevious(T[] numbers, int i) {
        return (numbers[i].compareTo(numbers[i-1]) <= 0);
    }

    public T[] mergeSort(T[] values) {
        helper = Arrays.copyOf(values, values.length);
        return mergesort(values, 0, values.length - 1);
    }

    private T[] mergesort(T[] values, int low, int high) {
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

    private T[] merge(T[] values, int low, int middle, int high) {

        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            helper[i] = values[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {
            if (helper[i].compareTo(helper[j]) <= 0) {
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

    public T[] quickSort(T[] numbers) {
        if (numbers.length < 2) {
            return numbers;
        }
        T a = numbers[0];
        T b = numbers[numbers.length - 1];
        T c = numbers[numbers.length / 2];

        if ((a.compareTo(b) >= 0 && a.compareTo(c) <= 0) || (a.compareTo(b) <= 0 && a.compareTo(c) >= 0)) {
            return split(numbers, a);
        } else if ((b.compareTo(a) >= 0 && b.compareTo(c) <= 0) || (b.compareTo(a) >= 0 && b.compareTo(c) <= 0)) {
            return split(numbers, b);
        } else {
            return split(numbers, c);
        }
    }

    private T[] split(T[] numbers, T pivot) {
        T[] num2;
        num2 = splitArray(numbers, pivot, true);
        numbers = splitArray(numbers, pivot, false);
        num2 = quickSort(num2);
        numbers = quickSort(numbers);

        T[] newArray = Arrays.copyOf(numbers, numbers.length + num2.length + 1);
        newArray[numbers.length] = pivot;
        System.arraycopy(num2, 0, newArray, numbers.length + 1, num2.length);
        return newArray;
    }

    private T[] splitArray(T[] numbers, T pivot, boolean takeHigherThanPivot) {
        T[] newArray = Arrays.copyOf(numbers, 0);
        boolean pastPivot = false;
        for (T number : numbers) {
            if (number == pivot && takeHigherThanPivot) {
                if (!pastPivot) {
                    pastPivot = true;
                } else {
                    newArray = Arrays.copyOf(newArray, newArray.length + 1);
                    newArray[newArray.length - 1] = number;
                }
            } else if (number.compareTo(pivot) > 0 && takeHigherThanPivot) {
                newArray = Arrays.copyOf(newArray, newArray.length + 1);
                newArray[newArray.length - 1] = number;
            } else if (number.compareTo(pivot) < 0 && !takeHigherThanPivot) {
                newArray = Arrays.copyOf(newArray, newArray.length + 1);
                newArray[newArray.length - 1] = number;
            }
        }
        return newArray;
    }
}
