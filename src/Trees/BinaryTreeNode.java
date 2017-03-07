package Trees;

public class BinaryTreeNode<T> {
    private T data;
    private BinaryTreeNode leftChild;
    private BinaryTreeNode rightChild;

    public BinaryTreeNode(T data, BinaryTreeNode leftChild, BinaryTreeNode rightChild){
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public T getData(){
        return data;
    }
    public BinaryTreeNode getLeftChild(){
        return leftChild;
    }
    public BinaryTreeNode getRightChild(){
        return rightChild;
    }
    public void setLeftChild(BinaryTreeNode leftChild) {
        this.leftChild = leftChild;
    }
    public void setRightChild(BinaryTreeNode rightChild) {
        this.rightChild = rightChild;
    }
    public void setData(T data) {
        this.data = data;
    }
}
