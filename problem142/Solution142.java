package problem142;

public class Solution142 {

    static int MAX = 30_000;
    static double min = 10_000_000_000l;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        for (int a = 1; a < MAX; a++) {
            long l2 = a * a;
            for (int b = 1; b < a; b++) {
                long k2 = b * b;
                if (!isSquare(l2 - k2)) {
                    continue;
                }
                // System.out.println("l^2+k^2: " + l2 + " + " + k2 + " = " + (l2 + k2));
                int c = a + 1;
                long m2 = c * c;
                long top = (long) Math.sqrt(2 * l2 - k2);
                while ((!isSquare(m2 - l2) || !isSquare(m2 + k2 - l2)) && c < top) {
                    m2 = c * c;
                    c++;
                }
                if (c >= top)
                    continue;
                long temp = (-k2 + 2 * l2 + m2);
                if (temp % 2 == 0 && temp < min) {
                    min = temp;
                    System.out.println("x + y + z: " + (int) (min / 2));
                    long endTime = System.currentTimeMillis();
                    long elapsedTime = endTime - startTime;
                    System.out.println("Benchmark run time: " + elapsedTime + " milliseconds");
                    System.exit(0);
                }

            }
        }
    }

    static void print(long m, long l, long k) {
        int x = (int) (k + m) / 2;
        int y = (int) (m - k) / 2;
        int z = (int) (2 * l - k - m) / 2;

        System.out.println("x: " + x + " y: " + y + " z: " + z);

        System.out.println("x + y = " + (x + y) + " = (" + Math.sqrt(x + y) + ")^2");
        System.out.println("x - y = " + (x - y) + " = (" + Math.sqrt(x - y) + ")^2");
        System.out.println("x + z = " + (x + z) + " = (" + Math.sqrt(x + z) + ")^2");
        System.out.println("x - z = " + (x - z) + " = (" + Math.sqrt(x - z) + ")^2");
        System.out.println("y + z = " + (y + z) + " = (" + Math.sqrt(y + z) + ")^2");
        System.out.println("y - z = " + (y - z) + " = (" + Math.sqrt(y - z) + ")^2");
    }

    static boolean isSquare(long x) {
        long sqrt = (int) Math.sqrt(x);
        return sqrt * sqrt == x;
    }

}
