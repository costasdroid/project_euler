package problem144;

class Line {
    public double a;
    public double b;

    public Line(Point p1, Point p2) {
        this.a = (p2.y - p1.y) / (p2.x - p1.x);
        this.b = p2.y - a * p2.x;
    }

    public Line(double A, double B, double C) {
        this.a = -A / B;
        this.b = -C / B;
    }

    public Line(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Line(double a, Point p) {
        this.a = a;
        this.b = p.y - a * p.x;
    }

    public String equation() {
        return "y=" + a + "x" + (b > 0 ? "+" : "-") + Math.abs(b);
    }
}