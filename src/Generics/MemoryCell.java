package Generics;

public class MemoryCell<Object extends Comparable> implements Comparable<MemoryCell>{
    private Object storedValue;

    public Object read(){
        return storedValue;
    }

    public void write( Object x ) {
        storedValue = x;
    }

    @Override
    public int compareTo(MemoryCell o) {
        return read().compareTo(o.read());
    }
}