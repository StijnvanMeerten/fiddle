package Graphs;

public class Path implements Comparable<Path> {
    public Node dest;
    public double distance;

    public Path(Node d, double dist){
        this.dest = d;
        this.distance = dist;
    }

    @Override
    public int compareTo(Path p) {
        if(distance > p.distance){
            return 1;
        }else if(distance < p.distance){
            return -1;
        }
        return 0;
    }
}
