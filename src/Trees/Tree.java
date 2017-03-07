package Trees;

public class Tree<T> implements ApplyTree {
    TreeNode<T> root;

    public Tree(T rootItem){
        root = new TreeNode<T>(rootItem, null, null);
    }
    public TreeNode<T> getRoot() {
        return root;
    }
    public void setRoot(T item){
        root = new TreeNode<T>(item, null, null);
    }
    public TreeNode getNode(T item){
        return search(root, item);
    }
    private TreeNode search(TreeNode node, T item){
        if(node.getData() == item){
            return node;
        } else if(node.getChild() != null){
            search(node.getChild(), item);
        } else if(node.getNext() != null){
            search(node.getNext(), item);
        }
        return null;
    }
    private TreeNode getRightmostNode(TreeNode node){
        if(node.getNext() == null){
            return node;
        } else{
            return getRightmostNode(node.getNext());
        }
    }
    public void addChildToNodeToItem(T item){
        TreeNode node = getNode(item);
        if(node == null){
            throw new Error("Node not found");
        } else if(node.getChild() == null){
            node.setChild(new TreeNode(item, null, null));
        } else getRightmostNode(node.getChild()).setNext(new TreeNode(item, null, null));
    }

    @Override
    public Tree<Integer> raiseByOne(Tree bt) {
        return null;
    }

    @Override
    public Tree<Integer> raiseByOne(TreeNode node) {
        return null;
    }
}
