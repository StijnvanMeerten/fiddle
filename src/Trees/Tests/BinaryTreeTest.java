package Trees.Tests;

import Trees.BinaryTree;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class BinaryTreeTest {
    private BinaryTree<Integer> tree = new BinaryTree<Integer>(5);
    private String expectedString = "Root: 5" + System.lineSeparator() +
            "Node: 5 | Left Child: 6 | Right Child: 7" + System.lineSeparator() +
            "Node: 6 | Left Child: 8 | Right Child: null" + System.lineSeparator() +
            "Node: 8 | Left Child: null | Right Child: null" + System.lineSeparator() +
            "Node: 7 | Left Child: 9 | Right Child: null" + System.lineSeparator() +
            "Node: 9 | Left Child: null | Right Child: null";

    @Before
    public void prepare(){
        tree.addChildToNodeToItem(5);
        tree.addChildToNodeToItem(5);
        tree.getNode(5).getLeftChild().setData(6);
        tree.getNode(5).getRightChild().setData(7);

        tree.addChildToNodeToItem(6);
        tree.getNode(6).getLeftChild().setData(8);

        tree.addChildToNodeToItem(7);
        tree.getNode(7).getLeftChild().setData(9);
    }

    @Test
    public void countLeavesIsTwo() {
        Assert.assertEquals(2, tree.countLeafNodes(tree.getRoot()));
    }
    @Test
    public void countOneChildIsTwo() {
        Assert.assertEquals(2, tree.countNodesWithOneChild(tree.getRoot()));
    }
    @Test
    public void countTwoChildsIsOne() {
        Assert.assertEquals(1, tree.countNodesWithTwoChildren(tree.getRoot()));
    }

    @Test(expected=Error.class)
    public void cantAdd3Children() {
        tree.addChildToNodeToItem(5);
    }

    @Test(expected=Error.class)
    public void cantAddToNonExistingNode() {
        tree.addChildToNodeToItem(10);
    }

    @Test
    public void testToString(){
        System.out.println(tree.toString());
    }
}
