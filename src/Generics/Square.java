package Generics;

public class Square extends Shape implements Comparable<Square>{

    private double area;

    public Square(double area){
        this.area = area;
    }

    @Override
    public double area() {
        return area;
    }

    @Override
    public int compareTo(Square o) {
        if(this.area == o.area){
            return 0;
        }else if (this.area > o.area){
            return 1;
        }
        return -1;
    }
}
