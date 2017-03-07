package Lists;

public class HANLinkedList<T> {
    private HANLinkedListNode<T> first;

    public void addFirst(T value){
        HANLinkedListNode a = new HANLinkedListNode<T>(value);
        if(first != null){
            a.next = first;
        }
        first = a;
    }

    public void removeFirst(){
        if(first.next != null) {
            first = first.next;
        } else{
            first = null;
        }
    }

    public void insert(int index, T value){
        if(index == 0){
            addFirst(value);
        } else {
            HANLinkedListNode tempNode = first;
            for (int i = 0; i < index; i++) {
                if (tempNode.next != null) {
                    tempNode = tempNode.next;
                }
            }
            HANLinkedListNode temp2 = new HANLinkedListNode<T>(value);
            if (tempNode.next != null) {
                temp2.next = tempNode.next;
            }
            tempNode.next = temp2;
        }
    }

    public void delete(int index){
        if(index==0){
            removeFirst();
        }
        HANLinkedListNode tempNode = first;
        for(int i=0; i<index-1; i++){
            if(tempNode.next != null) {
                tempNode = tempNode.next;
            }
        }
        if(tempNode.next != null && tempNode.next.next != null) {
            tempNode.next = tempNode.next.next;
        } else {
            tempNode.next = null;
        }
    }

    public Object get(int index){
        if(index == 0){
            return first.data;
        }
        HANLinkedListNode tempNode = first;
        for(int i=0; i<index; i++){
            if(tempNode.next != null) {
                tempNode = tempNode.next;
            }
        }
        return tempNode.data;
    }

    public String toString(){
        HANLinkedListNode tempNode = first;
        StringBuilder stringBuilder = new StringBuilder();
        while(tempNode != null){
             stringBuilder.append(tempNode.data.toString());
             tempNode = tempNode.next;
        }
        return stringBuilder.toString();
    }

    class HANLinkedListNode<T> {
        private T data;
        private HANLinkedListNode next;

        public HANLinkedListNode(T data){
            this.data = data;
        }
    }
}
