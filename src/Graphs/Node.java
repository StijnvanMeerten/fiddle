package Graphs;

import java.util.LinkedList;

public class Node {
    public String name;
    public LinkedList<Edge> adjacent;
    public double distance;
    public Node previous;
    public int scratch;

    public Node(String n){
        this.name = n;
        adjacent = new LinkedList<Edge>();
        reset();
    }
    public void reset(){
        distance = Graph.INFINITY;
        previous = null;
        scratch = 0;
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append(name);
        s.append(System.lineSeparator());
        for(Edge e : adjacent){
            s.append(name);
            s.append(" to ");
            s.append(e.dest.name );
            s.append(" = ");
            s.append(e.distance);
            s.append(System.lineSeparator());
        }
        return s.toString();
    }
}
