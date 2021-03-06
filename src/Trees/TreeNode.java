package Trees;

public class TreeNode<T> {
    private T data;
    private TreeNode next;
    private TreeNode child;

    public TreeNode(T data){
        this.data = data;
    }

    public T getData(){
        return data;
    }
    public TreeNode getNext(){
        return next;
    }
    public TreeNode getChild(){
        return child;
    }
    public void setNext(TreeNode next) {
        this.next = next;
    }
    public void setChild(TreeNode child) {
        this.child = child;
    }
    public void setData(T data) {
        this.data = data;
    }
}
