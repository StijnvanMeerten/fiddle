package Lists;

public class HANStack<T> {

    HANLinkedList hanLinkedList = new HANLinkedList();
    int count = 0;

    public void push(T item){
        hanLinkedList.addFirst(item);
        count++;
    }
    public void pop(){
        hanLinkedList.removeFirst();
        count--;
    }
    public Object top(){
        return hanLinkedList.get(0);
    }
    public int getSize(){
        return count;
    }

    public String toString(){
        return hanLinkedList.toString();
    }
}
