package Trees.Tests;

import Trees.Tree;
import Trees.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TreeTest {

    private Tree<Integer> tree = new Tree<>(5);

    @Before
    public void prepare() {
        tree.addChildToNodeToItem(5);
        tree.addChildToNodeToItem(5);
        tree.getNode(5).getChild().setData(6);
        tree.getNode(5).getChild().getNext().setData(7);

        tree.addChildToNodeToItem(6);
        tree.getNode(6).getChild().setData(8);

        tree.addChildToNodeToItem(7);
        tree.getNode(7).getChild().setData(9);
    }

    @Test
    public void testRaiseByOne() {
        Tree<Integer> newTree = tree.raiseByOne(tree);
        Assert.assertNull(newTree.getNode(5));
        Assert.assertNotNull(newTree.getNode(10));
        Assert.assertEquals(Integer.valueOf(tree.getRoot().getData() + 1), newTree.getRoot().getData());
    }
}
