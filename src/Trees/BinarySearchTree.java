package Trees;

public class BinarySearchTree {
    private BinarySearchTreeNode root;

    public BinarySearchTree(int rootItem){
        root = new BinarySearchTreeNode(rootItem);
    }
    public BinarySearchTreeNode getRoot() {
        return root;
    }

    public BinarySearchTreeNode getNode(int item){
        return search(root, item);
    }
    private BinarySearchTreeNode search(BinarySearchTreeNode node, int item){
        if (node.getData() == item){
            return node;
        }else if(item < node.getData()){
            if(node.getLeftChild() != null){
                return search(node.getLeftChild(), item);
            }
        } else if(item > node.getData()){
            if(node.getRightChild()!= null){
                return search(node.getRightChild(), item);
            }
        } return null;
    }

    public BinarySearchTreeNode findMin(){
        return getSmallestNode(root);
    }
    private BinarySearchTreeNode getSmallestNode(BinarySearchTreeNode node){
        if(node.getLeftChild() == null){
            return node;
        } return getSmallestNode(node.getLeftChild());
    }

    public BinarySearchTreeNode findMax(){
        return getBiggestNode(root);
    }
    private BinarySearchTreeNode getBiggestNode(BinarySearchTreeNode node){
        if(node.getRightChild() == null){
            return node;
        } return getBiggestNode(node.getRightChild());
    }

    public void addItem(int item) {
        add(root, item);
    }
    private void add(BinarySearchTreeNode node, int item){
        if(item < node.getData()){
            if(node.getLeftChild() != null){
                add(node.getLeftChild(), item);
            } else{
                node.setLeftChild(new BinarySearchTreeNode(item));
            }
        } else if(item > node.getData()){
            if(node.getRightChild() != null){
                add(node.getRightChild(), item);
            } else{
                node.setRightChild(new BinarySearchTreeNode(item));
            }
        }else if (item == node.getData()) {
            throw new Error("Node already exists!");
        }
    }

    public void deleteItem(int item){
        BinarySearchTreeNode temp = getNode(item);
        if(temp == null) {
            throw new Error("Node does not exist!");
        } else if(temp == root){
            root = null;
            //Only equal if null, so if both are null then..
        } else if(temp.getLeftChild() == temp.getRightChild()){
            if(item < findParent(root, item).getData()) {
                findParent(root, item).setLeftChild(null);
            } else{
                findParent(root, item).setRightChild(null);
            }
        } else if(temp.getRightChild() == null){
            findParent(root, item).setLeftChild(temp.getLeftChild());
        } else {
            int tmp = findLeftMostChild(temp.getRightChild()).getData();
            BinarySearchTreeNode tmpCopy = getNode(tmp); //This variable exists solely to prevent having to call getNode 2 to 3 times.

            if(tmpCopy.getRightChild() != null || tmpCopy.getLeftChild() != null){
                deleteItem(tmpCopy.getData());
            }
            if(item < findParent(root, item).getData()) {
                findParent(root, item).getLeftChild().setData(tmp);
            } else{
                findParent(root, item).getRightChild().setData(tmp);
            }
        }
    }

    private BinarySearchTreeNode findParent(BinarySearchTreeNode node, int item){
        if(node.getLeftChild().getData() == item || node.getRightChild().getData() == item){
            return node;
        } else if(item < node.getData()){
            return findParent(node.getLeftChild(), item);
        } return findParent(node.getRightChild(), item);
    }
    private BinarySearchTreeNode findLeftMostChild(BinarySearchTreeNode node){
        if(node.getLeftChild() == null){
            return node;
        }
        return findLeftMostChild(node.getLeftChild());
    }
}
