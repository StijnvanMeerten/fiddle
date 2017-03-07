package Trees.Tests;

import Trees.BinarySearchTree;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class BinarySearchTreeTest {
    private BinarySearchTree tree = new BinarySearchTree(10);

    @Before
    public void prepare(){
        tree.addItem(6);
        tree.addItem(14);
        tree.addItem(9);
        tree.addItem(3);
        tree.addItem(19);
        tree.addItem(11);
        tree.addItem(2);
        tree.addItem(7);
        tree.addItem(8);
    }

    @Test
    public void findBiggestNode(){
        Assert.assertEquals(tree.getNode(19), tree.findMax());
    }

    @Test
    public void findSmallestNode() {
        Assert.assertEquals(tree.getNode(2), tree.findMin());
    }

    @Test(expected=Error.class)
    public void cantAddSameNode() {
        tree.addItem(7);
    }

    @Test(expected=Error.class)
    public void cantDeleteNonExistingNode() {
        tree.deleteItem(20);
    }

    @Test
    public void tryDeletingRoot(){
        tree.deleteItem(10);
        Assert.assertNull(tree.getRoot());
    }

    @Test
    public void tryDeletingNodeWithoutChildrenLeftSide(){
        tree.deleteItem(2);
        Assert.assertNull(tree.getNode(3).getLeftChild());
        Assert.assertNull(tree.getNode(2));
    }

    @Test
    public void tryDeletingNodeWithoutChildrenRightSide(){
        tree.deleteItem(19);
        Assert.assertNull(tree.getNode(14).getRightChild());
        Assert.assertNull(tree.getNode(19));
    }

    @Test
    public void tryDeletingNodeWithOneLeftChild(){
        tree.deleteItem(3);
        Assert.assertEquals(tree.getNode(2), tree.getNode(6).getLeftChild());
        Assert.assertNull(tree.getNode(3));
    }

    @Test
    public void tryDeletingNodeWithOneRightChild(){
        tree.deleteItem(7);
        Assert.assertEquals(tree.getNode(9).getLeftChild(), tree.getNode(8));
        Assert.assertNull(tree.getNode(7));
    }

    @Test
    public void tryDeletingNodeWithOneLeftAndOneRightChild(){
        tree.deleteItem(14);
        Assert.assertEquals(tree.getNode(19).getLeftChild(), tree.getNode(11));
        Assert.assertEquals(tree.getNode(10).getRightChild(), tree.getNode(19));
        Assert.assertNull(tree.getNode(14));
    }

    @Test
    public void tryDeletingNodeWithSeveralLeftAndRightChildren(){
        tree.deleteItem(6);
        Assert.assertEquals(tree.getNode(10).getLeftChild(), tree.getNode(7));
        Assert.assertEquals(tree.getNode(7).getLeftChild(), tree.getNode(3));
        Assert.assertEquals(tree.getNode(7).getRightChild(), tree.getNode(9));
        Assert.assertEquals(tree.getNode(9).getLeftChild(), tree.getNode(8));
        Assert.assertNull(tree.getNode(6));
    }
}
