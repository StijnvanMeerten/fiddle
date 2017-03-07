package Lists;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomArrayList {
    private int[] array;
    private int intsInList;

    public CustomArrayList(){
        array = new int[1];
        intsInList = 0;
    }

    public void add(int value){
        if(intsInList >= array.length){
            array = Arrays.copyOf(array, array.length*2);
        }
        array[intsInList] = value;
        intsInList++;
    }

    public int get(int index){
        return array[index];
    }

    public void set(int index, int value){
        if(index<array.length-1){
            array[index] = value;
        }
    }

    public String toString(){
        return Arrays.toString(Arrays.copyOf(array, intsInList));
    }
}
