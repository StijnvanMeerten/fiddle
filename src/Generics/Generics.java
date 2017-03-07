package Generics;

public class Generics{
    public static <T extends Comparable> T getSmallest(T[] array){
        int smallest = -1;

        for (int i=0; i<array.length; i++) {
            if (smallest == -1 || array[smallest].compareTo(array[i]) == 1){
                smallest = i;
            }
        }
        return array[smallest];
    }
}
