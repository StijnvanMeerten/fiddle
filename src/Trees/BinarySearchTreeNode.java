package Trees;

public class BinarySearchTreeNode {
    private int data;
    private BinarySearchTreeNode leftChild;
    private BinarySearchTreeNode rightChild;

    public BinarySearchTreeNode(int data){
        this.data = data;
    }

    public int getData(){
        return data;
    }
    public BinarySearchTreeNode getLeftChild(){
        return leftChild;
    }
    public BinarySearchTreeNode getRightChild(){
        return rightChild;
    }
    public void setLeftChild(BinarySearchTreeNode leftChild) {
        this.leftChild = leftChild;
    }
    public void setRightChild(BinarySearchTreeNode rightChild) {
        this.rightChild = rightChild;
    }
    public void setData(int data) {
        this.data = data;
    }
}
