package Graphs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class GraphTest {
    private Graph g = new Graph();
    private String resultString = "Nijmegen" + System.lineSeparator() +
            "Nijmegen to Arnhem = 30.0" + System.lineSeparator() +
            "Utrecht" +System.lineSeparator() +
            "Utrecht to Arnhem = 30.0" +System.lineSeparator() +
            "Utrecht to Zwolle = 60.0" + System.lineSeparator() +
            "Zutphen" + System.lineSeparator() +
            "Zutphen to Zwolle = 45.0" + System.lineSeparator() +
            "Zwolle" + System.lineSeparator() +
            "Arnhem" + System.lineSeparator() +
            "Arnhem to Dieren = 15.0" + System.lineSeparator() +
            "Arnhem to Utrecht = 30.0"+ System.lineSeparator() +
            "Dieren" + System.lineSeparator() +
            "Dieren to Zutphen = 15.0" + System.lineSeparator();

    @Before
    public void pre(){
        g.addEdge("Nijmegen", "Arnhem", 30);
        g.addEdge("Arnhem", "Dieren", 15);
        g.addEdge("Dieren", "Zutphen", 15);
        g.addEdge("Zutphen", "Zwolle", 45);
        g.addEdge("Utrecht", "Arnhem", 30);
        g.addEdge("Arnhem", "Utrecht", 30);
        g.addEdge("Utrecht", "Zwolle", 60);
    }

    @Test
    public void testToString(){
        Assert.assertEquals(resultString, g.toString());
    }

    @Test
    public void unWeightedArnhem(){
        g.unweighted("Arnhem");
        double[] d = {0.0, 1.0, 2.0, 2.0, 0.0, 1.0};
        Assert.assertArrayEquals(d, g.getPreviousDistances(), 2);
    }


    @Test
    public void DijkstraArnhem(){
        g.dijkstra("Arnhem");
        double[] d = {0.0, 30.0, 30.0, 75.0, 0.0, 15.0};
        Assert.assertArrayEquals(d, g.getPreviousDistances(), 2);
    }

    @Test
    public void isConnectedFalse(){
        Assert.assertFalse(g.isConnected());
    }

    @Test
    public void isConnectedTrue(){
        g.addEdge("Zwolle", "Zutphen", 45);
        Assert.assertTrue(g.isConnected());
    }

    @Test
    public void isConnectedOnlyToItselfIsFalse(){
        g.addEdge("Zwolle", "Zwolle", 5);
        Assert.assertFalse(g.isConnected());
    }

    @Test
    public void isConnectedToItselfAndOthersIsTrue(){
        g.addEdge("Zwolle", "Zwolle", 5);
        g.addEdge("Zwolle", "Zutphen", 45);
        Assert.assertTrue(g.isConnected());
    }

    @Test
    public void oneNodeInList(){
        g = new Graph();
        g.addEdge("Zwolle","Zwolle", 5);
        Assert.assertTrue(g.isConnected());
    }

    @Test
    public void emptyList(){
        g = new Graph();
        Assert.assertTrue(g.isConnected());
    }
}
