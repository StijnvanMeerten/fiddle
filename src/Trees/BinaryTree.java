package Trees;

public class BinaryTree<T> implements ApplyBinaryTree {
    private BinaryTreeNode<T> root;

    public BinaryTree(T rootItem){
        root = new BinaryTreeNode<T>(rootItem, null, null);
    }
    public BinaryTreeNode<T> getRoot() {
        return root;
    }

    public BinaryTreeNode getNode(T item){
        return search(root, item);
    }
    private BinaryTreeNode search(BinaryTreeNode node, T item){
        BinaryTreeNode temp;
        if (node.getData() == item){
            return node;
        }else if(node.getLeftChild()!= null){
            if(search(node.getLeftChild(), item) != null){
                temp = search(node.getLeftChild(), item);
                if(temp != null && temp.getData() == item){
                    return temp;
                }
            }
        }
        if(node.getRightChild()!= null){
            if(search(node.getRightChild(), item) != null){
                return search(node.getRightChild(), item);
            }
        }
        return null;
    }
    public void addChildToNodeToItem(T item) {
        BinaryTreeNode node = getNode(item);
        if (node == null) {
            throw new Error("Node not found");
        } else if (node.getLeftChild() == null) {
            node.setLeftChild(new BinaryTreeNode(item, null, null));
        } else if (node.getRightChild() == null) {
            node.setRightChild(new BinaryTreeNode(item, null, null));
        } else {
            throw new Error("Node already has two children!");
        }
    }

    public int countLeafNodes(BinaryTreeNode node){
        if(node.getLeftChild() != null){
            if(node.getRightChild() == null){
                return countLeafNodes(node.getLeftChild());
            } return countLeafNodes(node.getLeftChild()) + countLeafNodes(node.getRightChild());
        } else if(node.getRightChild() != null){
            return countLeafNodes(node.getRightChild());
        }
        return 1;
    }
    public int countNodesWithOneChild(BinaryTreeNode node){
        if(node.getLeftChild() != null){
            if(node.getRightChild() == null){
                return countNodesWithOneChild(node.getLeftChild()) + 1;
            } return countNodesWithOneChild(node.getLeftChild()) + countNodesWithOneChild(node.getRightChild());
        } else if(node.getRightChild() != null){
            return countNodesWithOneChild(node.getRightChild()) + 1;
        }
        return 0;
    }
    public int countNodesWithTwoChildren(BinaryTreeNode node){
        if(node.getLeftChild() != null){
            if(node.getRightChild() == null){
                return countNodesWithTwoChildren(node.getLeftChild());
            } return countNodesWithTwoChildren(node.getLeftChild()) + countNodesWithTwoChildren(node.getRightChild()) + 1;
        } else if(node.getRightChild() != null){
            return countNodesWithTwoChildren(node.getRightChild());
        }
        return 0;
    }

    public String toString(){
        return "Root: " + root.getData() + getStringsFromNodes(root);
    }

    private String getStringsFromNodes(BinaryTreeNode node){
        StringBuilder builder = new StringBuilder();
        builder.append(System.lineSeparator() + "Node: " + node.getData().toString());

        if(node.getLeftChild() != null){
            if(node.getRightChild() == null){
                builder.append(" | Left Child: " + node.getLeftChild().getData());
                builder.append(" | Right Child: null");
                builder.append(getStringsFromNodes(node.getLeftChild()));
            } else {
                builder.append(" | Left Child: " + node.getLeftChild().getData());
                builder.append(" | Right Child: " + node.getRightChild().getData());
                builder.append(getStringsFromNodes(node.getLeftChild()));
                builder.append(getStringsFromNodes(node.getRightChild()));
            }
        } else if(node.getRightChild() != null){
            builder.append(" | Left Child: null");
            builder.append(" | Right Child: " + node.getRightChild().getData());
            builder.append(getStringsFromNodes(node.getRightChild()));
        } else {
            builder.append(" | Left Child: null");
            builder.append(" | Right Child: null");
        }
        return builder.toString();
    }

    @Override
    public Object apply(BinaryTree bt) {
        return apply(bt.getRoot());
    }

    @Override
    public Object apply(BinaryTreeNode node) {
        if(node.getLeftChild() != null){
            if(node.getRightChild() == null){
                return countLeafNodes(node.getLeftChild());
            } return countLeafNodes(node.getLeftChild()) + countLeafNodes(node.getRightChild());
        } else if(node.getRightChild() != null){
            return countLeafNodes(node.getRightChild());
        }
        return 1;
    }
}
