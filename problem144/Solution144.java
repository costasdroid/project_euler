package problem144;

public class Solution144 {

    static long hits = 0l;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        Ellipse e = new Ellipse(4, 1, 100);
        Point p1 = new Point(0.0, 10.1);
        Point p = new Point(1.4, -9.6);
        Line l = new Line(p1, p);
        p = intersect(e, l, p1);

        while (Math.abs(p.x) >= 0.01 || p.y < 0) {
            l = reflect(e, l, p);
            p = intersect(e, l, p);
        }
        System.out.println("hits: " + (hits - 1));
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Benchmark run time: " + elapsedTime + " milliseconds");
    }

    public static Point intersect(Ellipse e, Line l, Point p) {
        int A = e.A;
        int B = e.B;
        int C = e.C;
        double b = l.b;
        double a = l.a;
        double D = -A * b * b * B + A * C + a * a * B * C;
        // intersection of ellipse Ax^2+By^2=C and the line y=ax+b
        Point point1 = new Point((-a * b * B - Math.sqrt(D)) / (A + a * a * B),
                (A * b - a * Math.sqrt(D)) / (A + a * a * B));
        Point point2 = new Point((-a * b * B + Math.sqrt(D)) / (A + a * a * B),
                (A * b + a * Math.sqrt(D)) / (A + a * a * B));
        // compare the two points to determine wchich is not Point p
        Point point = compare(point1, point2, p);
        // System.out.println("the line intersects the ellipse at point " +
        // point.print());
        hits++;
        return point;
    }

    // pick the next point and not the origin one
    public static Point compare(Point p1, Point p2, Point p) {
        return (p1.x - p.x) * (p1.x - p.x) + (p1.y - p.y) * (p1.y - p.y) > (p2.x - p.x) * (p2.x - p.x)
                + (p2.y - p.y) * (p2.y - p.y) ? p1 : p2;
    }

    public static Line reflect(Ellipse e, Line l, Point p) {
        double a = l.a;
        double x = p.x;
        double y = p.y;
        int A = e.A;
        int B = e.B;

        double s1 = B * y / (A * x);
        double s2 = a;
        double s3 = (s1 * s1 * s2 + 2 * s1 - s2)
                / (1 + 2 * s1 * s2 - s1 * s1);
        Line line = new Line(s3, p);

        return line;
    }

    public static double pickOne(double k1, double k2, Line l) {
        return Math.abs(l.a - k1) > Math.abs(l.a - k2) ? k2 : k1;
    }
}
