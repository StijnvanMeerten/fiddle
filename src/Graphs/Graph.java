package Graphs;

import Lists.HANQueue;

import java.util.*;

public class Graph {
    public static final double INFINITY = Double.MAX_VALUE;

    public void addEdge(String sourceName, String destName, double cost){
        Node n = getNode(sourceName);
        Node m = getNode(destName);
        n.adjacent.add(new Edge(m, cost));
    }
    public void printPath(String destName){
        Node n = nodeMap.get(destName);
        if(n == null){
            throw new NoSuchElementException();
        }else if(n.distance == INFINITY) {
            System.out.println(destName + " is unreachable");
        }else{
            System.out.print("(Cost is :  " + n.distance + ") ");
            printPath(n);
            System.out.println();
        }
    }
    public void unweighted(String startName){
        clearAll();
        Node start = nodeMap.get(startName);
        if(start == null){
            throw new NoSuchElementException("Start node not found");
        }
        HANQueue<Node> queue = new HANQueue<>();
        queue.push(start);
        start.distance = 0;
        while(queue.getSize()>0){
            Node n = queue.top();
            queue.pop();
            for(Edge e : n.adjacent){
                Node m = e.dest;
                if(m.distance == INFINITY){
                    m.distance = n.distance+1;
                    m.previous = n;
                    queue.push(m);
                }
            }
        }
    }
    public void dijkstra(String startName){
        Node start = nodeMap.get(startName);
        if(start==null){
            throw new NoSuchElementException("Start node not found");
        }
        clearAll();

        PriorityQueue<Path> queue = new PriorityQueue<Path>();
        queue.add(new Path(start, 0));
        start.distance = 0;

        int nodesSeen = 0;
        while(!queue.isEmpty() && nodesSeen < nodeMap.size()){
            Path next = queue.remove();
            Node n = next.dest;

            if(n.scratch == 0){
                n.scratch = 1;
                nodesSeen++;
            }
            for(Edge e : n.adjacent){
                Node m = e.dest;

                if(e.distance < 0){
                    throw new NoSuchElementException("Graph has negative edges");
                }
                if(m.distance > n.distance + e.distance){
                    m.distance = n.distance + e.distance;
                    m.previous = n;
                    queue.add(new Path(m, m.distance));
                }
            }
        }
    }

    private Node getNode(String nodeName){
        Node n = nodeMap.computeIfAbsent(nodeName, k -> new Node(nodeName));
        return n;
    }
    private void printPath(Node dest){
        if(dest.previous != null){
            printPath(dest.previous);
            System.out.print(" to ");
        }
        System.out.print(dest.name);
    }
    private void clearAll(){
        for(Node n : nodeMap.values()){
            n.reset();
        }
    }
    private Map<String,Node> nodeMap = new HashMap<String,Node>();

    public boolean isConnected(){
        if(nodeMap.size() < 2){
            return true;
        }
        for(Node n : nodeMap.values()){
            if(n.adjacent.isEmpty()){
                return false;
            }
            boolean connectedToOtherThanItself = false;
            for(Edge e : n.adjacent){
                if (e.dest != n){
                    connectedToOtherThanItself = true;
                    break;
                }
            } if(!connectedToOtherThanItself){
                return false;
            }
        }
        return true;
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        for(Node n : nodeMap.values()){
            s.append(n.toString());
        }
        return s.toString();
    }

    public double[] getPreviousDistances(){
        double[] d = new double[0];
        for(Node n : nodeMap.values()){
            d = Arrays.copyOf(d, d.length+1);
            if(n.distance != INFINITY) {
                d[d.length - 1] = n.distance;
            }
        }
        return d;
    }
}
