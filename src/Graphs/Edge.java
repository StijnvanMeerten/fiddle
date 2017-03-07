package Graphs;

public class Edge {
    public Node dest;
    public double distance;

    public Edge(Node d, double dist){
        this.dest = d;
        this.distance = dist;
    }
}
