package Trees;

public class Tree<T> implements ApplyTree {
    TreeNode<T> root;

    public Tree(T rootItem){
        root = new TreeNode<T>(rootItem);
    }
    public TreeNode<T> getRoot() {
        return root;
    }
    public void setRoot(T item){
        root = new TreeNode<T>(item);
    }
    public TreeNode getNode(T item){
        return search(root, item);
    }
    private TreeNode search(TreeNode node, T item){
        if(node.getData() == item){
            return node;
        } else if(node.getChild() != null && search(node.getChild(), item) != null){
            return search(node.getChild(), item);
        } else if(node.getNext() != null){
            return search(node.getNext(), item);
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
            node.setChild(new TreeNode(item));
        } else getRightmostNode(node.getChild()).setNext(new TreeNode(item));
    }

    @Override
    public Tree<Integer> raiseByOne(Tree bt) {
        Tree newTree = new Tree(bt.getRoot().getData());
        return raiseEm(newTree, bt.root);
    }

    @Override
    public Tree<Integer> raiseByOne(TreeNode node) {
        Tree newTree = new Tree(node.getData());
        return raiseEm(newTree, node);
    }

    private Tree<Integer> raiseEm(Tree<Integer> newTree, TreeNode<Integer> node){
        if(node.getChild() != null){
            newTree.getNode(node.getData()).setChild(node.getChild());
            newTree = raiseEm(newTree, node.getChild());
        }
        if(node.getNext() != null){
            newTree.getNode(node.getData()).setNext(node.getNext());
            newTree = raiseEm(newTree, node.getNext());
        }
        newTree.getNode(node.getData()).setData(node.getData() + 1);
        return newTree;
    }
}
