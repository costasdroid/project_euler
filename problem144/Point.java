package problem144;

public class Point {

    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public String print() {
        return "( " + x + " , " + y + ")";
    }
}