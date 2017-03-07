package Lists;

import java.util.ArrayList;

public class HANQueue<T> {
    private ArrayList<T> arrayList = new ArrayList();

    public void push(T item){
        arrayList.add(item);
    }
    public void pop(){
        arrayList.remove(0);
    }
    public T top(){
        return arrayList.get(0);
    }
    public int getSize(){
        return arrayList.size();
    }

    public String toString(){
        return arrayList.toString();
    }
}
